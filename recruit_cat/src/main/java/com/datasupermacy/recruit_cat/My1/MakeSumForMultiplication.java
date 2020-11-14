package com.datasupermacy.recruit_cat.My1;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

import java.io.IOException;

public class MakeSumForMultiplication {

    static class MakeSumForMultiplicationMapper extends Mapper<LongWritable,Text,Text,IntWritable> {
        Text k = new Text();
        IntWritable v = new IntWritable();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] split = value.toString().split("\t");
            k.set(split[0]);
            v.set(Integer.parseInt(split[1]));
            context.write(k,v);
        }
    }

    static class MakeSumForMultiplicationReducer extends Reducer<Text,IntWritable,RecommendResult,IntWritable> {
        IntWritable v = new IntWritable();
        private RecommendResult rr = new RecommendResult();
        private MultipleOutputs<RecommendResult,IntWritable> mos;
        @Override
        protected void setup(Context context) throws IOException, InterruptedException {
//            mos = new MultipleOutputs<Text, IntWritable>(context);
          mos =  new MultipleOutputs<RecommendResult,IntWritable>(context);
        }

        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

            int sum = 0;
            for (IntWritable value:values){
                sum+=value.get();
            }
           v.set(sum);
//            context.write(key,v);

            String[] strs=key.toString().split(",");
            rr.setUid(strs[0]);
            rr.setJid(strs[1]);
            rr.setExp(sum);
//            context.write(rr, NullWritable.get());

                mos.write("first", key, v);
                mos.write("second", rr, NullWritable.get());

        }

        @Override
        protected void cleanup(Context context) throws IOException, InterruptedException {
            mos.close();
        }
    }

}
