package com.root.sort2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCombine extends Reducer<IntWritable, Text, IntWritable, Text> {
    private static final Text emptyText = new Text("");

    @Override
    protected void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        List<Integer> numbers = new ArrayList<>();
        for (Text value : values) {
            numbers.add(key.get());
        }

        Collections.sort(numbers);

        for (Integer num : numbers) {
            context.write(new IntWritable(num), emptyText);
        }
    }
}

