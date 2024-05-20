package com.root.sort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SortReducer extends Reducer<IntWritable, NullWritable, IntWritable, IntWritable> {
    private IntWritable lineNumber = new IntWritable(1);

    @Override
    protected void reduce(IntWritable key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        for (NullWritable value : values) {
            context.write(lineNumber, key); // 输出序号和数值 (lineNumber, sorted number)
            lineNumber.set(lineNumber.get() + 1); // 序号递增
        }
    }
}

