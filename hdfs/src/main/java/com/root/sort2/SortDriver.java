package com.root.sort2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.util.List;

public class SortDriver {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: SortDriver <input path> <output path>");
            System.exit(-1);
        }

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Sort Numbers");

        job.setJarByClass(SortDriver.class);
        job.setMapperClass(SortMapper.class);
        job.setCombinerClass(SortCombine.class);
        job.setReducerClass(SortReducer.class);

        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(Text.class);

        job.setInputFormatClass(CustomInputFormat.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // 这里可以获取并打印分片信息
        List<InputSplit> splits = FileInputFormat.getSplits(job);
        System.out.println("Total splits to process : " + splits.size());
        for (InputSplit split : splits) {
            System.out.println("Split details: " + split.toString());
        }

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

