package com.datasupermacy.recruit_cat.My1;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class UserBrowseListVector {

    static class UserBrowseListVectorMapper extends Mapper<LongWritable, Text,Text,Text>{
        //10001	20001,20005,20006,20007,20002
         Text k = new Text();
         Text v = new Text();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] split = value.toString().split("\t");
            String[] split1 = split[1].toString().split(",");

            for (String values:split1){
                k.set(values);
                v.set(split[0]+":1");
                context.write(k,v);
            }
        }
    }

    static class UserBrowseListVectorReducer extends Reducer<Text,Text,Text,Text>{
        Text v = new Text();
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            StringBuilder builder = new StringBuilder();
            for (Text value:values){
                builder.append(value.toString()).append(",");
            }
            v.set(builder.substring(0,builder.length()-1));
            context.write(key, v);
        }
    }
}
