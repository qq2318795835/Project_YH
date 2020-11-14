package com.datasupermacy.recruit_cat.My1;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JobConcurrenceMatrix {

    static class JobConcurrenceMatrixMapper extends Mapper<LongWritable, Text,Text,Text>{
        //20001      20001      3
        //20001      20002      2
        Text k = new Text();
        Text v = new Text();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            StringBuilder stringBuilder = new StringBuilder();
            String[] split = value.toString().split("\t");
            stringBuilder.append(split[1]).append(":").append(split[2]);

            k.set(split[0]);
            v.set(stringBuilder.toString());
            context.write(k,v);

        }
    }

    static class JobConcurrenceMatrixReducer extends Reducer<Text,Text,Text,Text>{
        Text v = new Text();
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            //20001      20001:3
            //20001      20002:2
            Iterator<Text> iterator = values.iterator();
            StringBuilder builder = new StringBuilder();
            while (iterator.hasNext()){
                builder.append(iterator.next()).append(",");
            }
            v.set(builder.toString().substring(0,builder.length()-1));
            context.write(key,v);
        }
    }
}
