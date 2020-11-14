package com.datasupermacy.recruit_cat.My1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class JobConcurrenceList {

    private final static Text k = new Text();
    private final static IntWritable v = new IntWritable(1);
    static class JobConcurrenceListMapper extends Mapper<LongWritable, Text,Text, IntWritable>{
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            //10001 20001,20005,20006,20007,20002

            String[] split = value.toString().split("\t");
            String[] split1 = split[1].split(",");

            for (int i=0;i<split1.length;i++){
                String job = split1[i];
                for (int j=0;j< split1.length;j++){
                    String job1 = split1[j];
                    k.set(job+"\t"+job1);
                    context.write(k, v);
                }
            }
        }
    }

    static class JobConcurrenceListReducer extends Reducer<Text,IntWritable,Text,IntWritable>{
        //20001 20001 1
        // 20001 20005 1
        // 20001 20006 1
        //.....
        //20005 20001 1
        //....
        //20002 20002 1
        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable value :values){
                sum+=value.get();
            }
            v.set(sum);
            context.write(key, v);
        }
    }

}
