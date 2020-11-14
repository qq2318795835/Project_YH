package com.datasupermacy.recruit_cat.My;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBInputFormat;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import java.io.IOException;

public class PersonalRecommendController {
    public static void PersonalRecommend() throws Exception {
        Configuration conf = new Configuration();
        Path out1 = new Path("hdfs://hadoop102:9000/DBout1");
        Path out6 = new Path("hdfs://hadoop102:9000/DBout6");
        Path out7 = new Path("hdfs://hadoop102:9000/DBout7");
        //--step7--
        Job job7 = Job.getInstance(conf);
        job7.setJarByClass(PersonalRecommendController.class);
        MultipleInputs.addInputPath(job7, out1, TextInputFormat.class, DuplicateDataForResult.DuplicateDataForResultFirstMapper.class);
        MultipleInputs.addInputPath(job7, out6, TextInputFormat.class, DuplicateDataForResult.DuplicateDataForResultSecondMapper.class);
        job7.setMapOutputKeyClass(Text.class);
        job7.setMapOutputValueClass(Text.class);
        job7.setReducerClass(DuplicateDataForResult.DuplicateDataForResultReducer.class);
        job7.setOutputKeyClass(Text.class);
        job7.setOutputValueClass(Text.class);
        job7.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job7, out7);
        job7.setNumReduceTasks(1);
        FileSystem fs = out7.getFileSystem(conf);
        if (fs.exists(out7)) {
            fs.delete(out7, true);
        }


        if (job7.waitForCompletion(true)) {
            //--step8--
            Job job8 = Job.getInstance(conf);
            job8.setJarByClass(PersonalRecommendController.class);

            job8.setMapperClass(SaveRecommendResultToDB.SaveRecommendResultToDBMapper.class);
            job8.setMapOutputKeyClass(Text.class);
            job8.setMapOutputValueClass(Text.class);
            job8.setInputFormatClass(TextInputFormat.class);
            TextInputFormat.addInputPath(job8, out7);

            job8.setReducerClass(SaveRecommendResultToDB.SaveRecommendResultToDBReducer.class);
            job8.setOutputKeyClass(RecommendResult.class);
            job8.setOutputValueClass(NullWritable.class);
            job8.setOutputFormatClass(DBOutputFormat.class);

            String driverclass = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/recruit_cat?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
            String username = "root";
            String passwd = "123456";
            DBConfiguration.configureDB(job8.getConfiguration(), driverclass, url, username, passwd);
            DBOutputFormat.setOutput(job8, "personal_recommend", "Uid", "Jid", "Exp");
            job8.waitForCompletion(true);
        }
    }
}