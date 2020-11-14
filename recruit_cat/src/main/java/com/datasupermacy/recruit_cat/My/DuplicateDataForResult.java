package com.datasupermacy.recruit_cat.My;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateDataForResult {
    static class DuplicateDataForResultFirstMapper extends Mapper<LongWritable, Text,Text,Text>{
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            //10001	20001,20005,20006,20007,20002
            String[] str = value.toString().split("\t");
            for (String s :str[1].split(",")){
                context.write(new Text(str[0]+","+s),new Text("r"+value.toString()));
            }

        }
    }

    static class DuplicateDataForResultSecondMapper extends Mapper<LongWritable,Text,Text,Text>{
        Text k = new Text();
        Text v = new Text();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            //10001,20001	10
            String[] split = value.toString().split("\t");
            k.set(split[0]);
            v.set("u"+value.toString());
            context.write(k,v);
        }
    }

    static class DuplicateDataForResultReducer extends Reducer<Text,Text,Text,Text>{
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            Map<String,String> map=new HashMap<String, String>();
            List<String> list=new ArrayList<String>();
            for(Text value : values){
                String val=value.toString();
                if(val.charAt(0)=='r') list.add(key.toString());
                if(val.charAt(0)=='u') map.put(key.toString(),val.substring(1));
            }
            for(String str : list){
                map.remove(str);
            }
            for(String str : map.keySet()){
                String[] strs=map.get(str).split(",");
                context.write(new Text(strs[0]),new Text(strs[1]));
            }
        }

        }

}
