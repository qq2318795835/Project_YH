package com.datasupermacy.recruit_cat.My1;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MultiplyJobMatrixAndUserVector {

    static class MultiplyJobMatrixAndUserVectorFirstMapper extends Mapper<LongWritable, Text,Text,Text>{
        Text K = new Text();
        Text v = new Text();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            //20001	20007:1,20001:3,20002:2,20005:2,20006:2  处理商品共现
            String[] split = value.toString().split("\t");
            K.set(split[0]);
            v.set("m"+split[1]);

           context.write(K, v);
        }
    }
    static class MultiplyJobMatrixAndUserVectorSecondMapper extends Mapper<LongWritable,Text,Text,Text>{
        Text K = new Text();
        Text v = new Text();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            //20001	10004:1,10001:1,10005:1 处理用户浏览向量
            String[] s = value.toString().split("\t");
            K.set(s[0]);
            v.set("v"+s[1]);
            context.write(K, v);

        }
    }

    static class MultiplyJobMatrixAndUserVectorReducer extends Reducer<Text,Text,Text,Text>{
        //20001	m20007:1,20001:3,20002:2,20005:2,20006:2
        //20001	v10004:1,10001:1,10005:1
        Text K = new Text();
        Text va = new Text();
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            String ms[]=null;
            String vs[]=null;

            for(Text value : values){
                String s = value.toString();
                if(s.charAt(0)=='m'){
                    ms=s.substring(1).split(",");
                }
                if (s.charAt(0)=='v'){
                    vs=s.substring(1).split(",");
                }
            }
            //20001	20007:1 20001:3 20002:2 20005:2 20006:2
            //20001	10004:1 10001:1 10005:1
            for (String m:ms){
                for (String v:vs){
                    String mms[] = m.split(":");
                    String vvs[] = v.split(":");
                    long vv = Long.parseLong(vvs[1]);
                    long mm = Long.parseLong(mms[1]);
                    K.set(vvs[0]+","+mms[0]);
                    va.set((vv*mm)+"");
                    context.write(K,va);
                }
            }
        }
    }

}
