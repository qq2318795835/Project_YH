package com.datasupermacy.recruit_cat.My1;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBInputFormat;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class RecommendController {
    public static void hotAnalysis() throws Exception{

        Configuration conf = new Configuration();
        Path out1 = new Path("hdfs://hadoop102:9000/DBout1");
        Path out2 = new Path("hdfs://hadoop102:9000/DBout2");
        Path out3 = new Path("hdfs://hadoop102:9000/DBout3");
        Path out4 = new Path("hdfs://hadoop102:9000/DBout4");
        Path out5 = new Path("hdfs://hadoop102:9000/DBout5");
        Path out6 = new Path("hdfs://hadoop102:9000/DBout6");
        //--step1--
        DBConfiguration.configureDB(conf, "com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/recruit_cat?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8",
                "root", "123456");
        Job job1 = Job.getInstance(conf, UserBrowseList.class.getSimpleName());
        job1.setJarByClass(RecommendController.class);
        job1.setMapperClass(UserBrowseList.UserBrowseListMapper.class);
        job1.setMapOutputKeyClass(Text.class);
        job1.setMapOutputValueClass(Text.class);
        job1.setInputFormatClass(TextInputFormat.class);

        DBInputFormat.setInput(job1, RecommendResult.class, "select Uid,Jid,Exp from favorites_list", "select count(1) from favorites_list");

        job1.setReducerClass(UserBrowseList.UserBrowseListReducer.class);
        job1.setOutputKeyClass(Text.class);
        job1.setOutputValueClass(Text.class);
        job1.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job1, out1);
        //job1.waitForCompletion(true);

        FileSystem fs = out1.getFileSystem(conf);
        if (fs.exists(out1)) {
            fs.delete(out1, true);
        }

        if (job1.waitForCompletion(true)) {
            //--step2--
            Job job2 = Job.getInstance(conf, JobConcurrenceList.class.getSimpleName());
            job2.setJarByClass(RecommendController.class);

            job2.setMapperClass(JobConcurrenceList.JobConcurrenceListMapper.class);
            job2.setMapOutputKeyClass(Text.class);
            job2.setMapOutputValueClass(IntWritable.class);
            job2.setInputFormatClass(TextInputFormat.class);

            TextInputFormat.addInputPath(job2, out1);

            job2.setReducerClass(JobConcurrenceList.JobConcurrenceListReducer.class);
            job2.setOutputKeyClass(Text.class);
            job2.setOutputValueClass(IntWritable.class);
            job2.setOutputFormatClass(TextOutputFormat.class);
            TextOutputFormat.setOutputPath(job2, out2);
            //job2.waitForCompletion(true);

            if (fs.exists(out2)) {
                fs.delete(out2, true);
            }

            if (job2.waitForCompletion(true)) {

                //--step3--
                Job job3 = Job.getInstance(conf, JobConcurrenceMatrix.class.getSimpleName());
                job3.setJarByClass(RecommendController.class);

                job3.setMapperClass(JobConcurrenceMatrix.JobConcurrenceMatrixMapper.class);
                job3.setMapOutputKeyClass(Text.class);
                job3.setMapOutputValueClass(Text.class);
                job3.setInputFormatClass(TextInputFormat.class);

                TextInputFormat.addInputPath(job3, out2);

                job3.setReducerClass(JobConcurrenceMatrix.JobConcurrenceMatrixReducer.class);
                job3.setOutputKeyClass(Text.class);
                job3.setOutputValueClass(Text.class);
                job3.setOutputFormatClass(TextOutputFormat.class);
                TextOutputFormat.setOutputPath(job3, out3);
                // job1.waitForCompletion(true);

                if (fs.exists(out3)) {
                    fs.delete(out3, true);
                }

                if (job3.waitForCompletion(true)) {
                    //--step4--
                    Job job4 = Job.getInstance(conf, UserBrowseListVector.class.getSimpleName());
                    job4.setJarByClass(RecommendController.class);

                    job4.setMapperClass(UserBrowseListVector.UserBrowseListVectorMapper.class);
                    job4.setMapOutputKeyClass(Text.class);
                    job4.setMapOutputValueClass(Text.class);
                    job4.setInputFormatClass(TextInputFormat.class);
                    // 数据来源：第1步的计算结果或者原始数据
                    TextInputFormat.addInputPath(job4, out1);

                    job4.setReducerClass(UserBrowseListVector.UserBrowseListVectorReducer.class);
                    job4.setOutputKeyClass(Text.class);
                    job4.setOutputValueClass(Text.class);
                    job4.setOutputFormatClass(TextOutputFormat.class);
                    TextOutputFormat.setOutputPath(job4, out4);

                    if (fs.exists(out4)) {
                        fs.delete(out4, true);
                    }

                    if (job4.waitForCompletion(true)) {
                        //--step5--
                        Job job5 = Job.getInstance(conf, MultiplyJobMatrixAndUserVector.class.getSimpleName());
                        job5.setJarByClass(RecommendController.class);

                        // 数据来源：第1步的计算结果或者原始数据
                        MultipleInputs.addInputPath(job5, out3, TextInputFormat.class, MultiplyJobMatrixAndUserVector.MultiplyJobMatrixAndUserVectorFirstMapper.class);
                        MultipleInputs.addInputPath(job5, out4, TextInputFormat.class, MultiplyJobMatrixAndUserVector.MultiplyJobMatrixAndUserVectorSecondMapper.class);
                        job5.setMapOutputKeyClass(Text.class);
                        job5.setMapOutputValueClass(Text.class);

                        job5.setReducerClass(MultiplyJobMatrixAndUserVector.MultiplyJobMatrixAndUserVectorReducer.class);
                        job5.setOutputKeyClass(Text.class);
                        job5.setOutputValueClass(Text.class);
                        job5.setOutputFormatClass(TextOutputFormat.class);
                        TextOutputFormat.setOutputPath(job5, out5);

                        if (fs.exists(out5)) {
                            fs.delete(out5, true);
                        }

                        if (job5.waitForCompletion(true)) {
                            if (fs.exists(out6)) {
                                fs.delete(out6, true);
                            }
                            //--step6--
                            Job job6 = Job.getInstance(conf, MakeSumForMultiplication.class.getSimpleName());
                            job6.setJarByClass(RecommendController.class);

                            job6.setMapperClass(MakeSumForMultiplication.MakeSumForMultiplicationMapper.class);
                            job6.setMapOutputKeyClass(Text.class);
                            job6.setMapOutputValueClass(IntWritable.class);
                            job6.setInputFormatClass(TextInputFormat.class);
                            // 数据来源：第5步的计算结果
                            TextInputFormat.addInputPath(job6, out5);

                            job6.setReducerClass(MakeSumForMultiplication.MakeSumForMultiplicationReducer.class);
                            job6.setOutputKeyClass(RecommendResult.class);
                            job6.setOutputValueClass(NullWritable.class);
                           // job6.setOutputFormatClass(DBOutputFormat.class);
                            MultipleOutputs.addNamedOutput(job6,"first",TextOutputFormat.class,Text.class,IntWritable.class);
                            MultipleOutputs.addNamedOutput(job6,"second",DBOutputFormat.class,RecommendResult.class,NullWritable.class);
                            FileOutputFormat.setOutputPath(job6, out6);

                            String driverclass = "com.mysql.cj.jdbc.Driver";
                            String url = "jdbc:mysql://localhost:3306/recruit_cat?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
                            String username = "root";
                            String passwd = "123456";
                            DBConfiguration.configureDB(job6.getConfiguration(), driverclass, url, username, passwd);
                            DBOutputFormat.setOutput(job6, "recommend", "Uid", "Jid", "Exp");
                            job6.waitForCompletion(true);
                        }
                    }
                }
            }
        }
    }
}
