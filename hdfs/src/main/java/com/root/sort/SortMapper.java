package com.root.sort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SortMapper extends Mapper<LongWritable, Text, IntWritable, NullWritable> {
    private IntWritable number = new IntWritable();
    private int count = 0;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (count < 20) { // 只处理前 20 个数字
            int num = Integer.parseInt(value.toString());
            number.set(num);
            context.write(number, NullWritable.get()); // 输出键值对 (number, NullWritable)
            count++; // 计数加一
        }
    }
}
