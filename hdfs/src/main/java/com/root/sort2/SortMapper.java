package com.root.sort2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SortMapper extends Mapper<LongWritable, Text, IntWritable, Text> {
    private static final IntWritable number = new IntWritable();
    private static final Text emptyText = new Text("");

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        int num = Integer.parseInt(value.toString().trim());
        number.set(num);
        context.write(number, emptyText);
    }
}

