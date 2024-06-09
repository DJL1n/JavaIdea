package com.root.sort2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

        // 提交作业之前获取并打印分片信息
        FileInputFormat inputFormat = new CustomInputFormat();
        List<InputSplit> splits = inputFormat.getSplits(job);
        System.out.println("Total splits to process: " + splits.size());
        for (InputSplit split : splits) {
            System.out.println("Split details: " + split.toString());
        }

        // 将分片信息写入文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("splits_info.txt"))) {
            writer.write("Total splits to process: " + splits.size() + "\n");
            for (InputSplit split : splits) {
                writer.write("Split details: " + split.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

