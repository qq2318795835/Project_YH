package com.datasupermacy.recruit_cat.My1;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class UserBrowseList  {

    static class UserBrowseListMapper extends Mapper<LongWritable, RecommendResult,Text,Text>{
        Text k = new Text();
        Text v = new Text();

        @Override
        protected void map(LongWritable key, RecommendResult value, Context context) throws IOException, InterruptedException {
            String[] split = value.toString().split("\t");
            k.set(split[0]);
            v.set(split[1]);
            context.write(k,v);
        }
    }
    static class UserBrowseListReducer extends Reducer<Text,Text,Text,Text>{
        Text v = new Text();
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
           //10001 20001
            //     20002

            Iterator<Text> iterator = values.iterator();//迭代器
            StringBuilder builder = new StringBuilder();
            //拼接时字符串
            while (iterator.hasNext()){//判断是否有下一个值
                builder.append(iterator.next().toString()+",");//两个值之间 用,连接
            }
            String result=builder.substring(0,builder.length()-1);//截取到最后一个,
            v.set(result);
            context.write(key,v);
        }
    }
}
