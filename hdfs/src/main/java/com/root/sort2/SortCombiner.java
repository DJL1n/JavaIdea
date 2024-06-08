package com.root.sort2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

public class SortCombiner extends Reducer<IntWritable, NullWritable, IntWritable, NullWritable> {
    private TreeSet<IntWritable> sortedSet = new TreeSet<>();

    @Override
    protected void reduce(IntWritable key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        sortedSet.add(key);
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        for (IntWritable num : sortedSet) {
            context.write(num, NullWritable.get());
        }
    }
}
