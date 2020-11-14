package com.datasupermacy.recruit_cat.My;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

;

public class SaveRecommendResultToDB {

    static class SaveRecommendResultToDBMapper extends Mapper<LongWritable, Text,Text,Text>{
        Text k = new Text();
        Text v = new Text();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] s = value.toString().split("\t");
            k.set(s[0]+"\t"+s[1]);
            v.set(s[2]);
            context.write(k, v);
        }
    }

    static class SaveRecommendResultToDBReducer extends Reducer<Text,Text, RecommendResult,NullWritable>{
        private RecommendResult rr = new RecommendResult();
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            String[] strs=key.toString().split("\t");
            rr.setUid(strs[0]);
            rr.setJid(strs[1]);
            rr.setExp(Integer.parseInt(values.iterator().next().toString()));
            context.write(rr, NullWritable.get());
        }


    }
}