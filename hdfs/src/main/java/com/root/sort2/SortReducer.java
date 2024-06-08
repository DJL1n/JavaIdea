package com.root.sort2;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class SortReducer extends Reducer<IntWritable, NullWritable, IntWritable, IntWritable> {
    private IntWritable lineNumber = new IntWritable(1);

    @Override
    protected void reduce(IntWritable key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        context.write(lineNumber, key);
        lineNumber.set(lineNumber.get() + 1);
    }
}