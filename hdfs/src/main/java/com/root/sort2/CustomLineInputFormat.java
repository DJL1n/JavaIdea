package com.root.sort2;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.LineRecordReader;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomInputFormat extends InputFormat<Text, LongWritable> {

    @Override
    public List<InputSplit> getSplits(JobContext jobContext) throws IOException {
        List<InputSplit> splits = new ArrayList<>();
        // 获取输入路径
        Path[] paths = FileInputFormat.getInputPaths(jobContext);
        // 每40行一个切片
        int linesPerSplit = 40;

        for (Path path : paths) {
            long totalLines = countLines(path); // 需要实现countLines方法来统计文件行数
            long start = 0;

            while (start < totalLines) {
                // 计算切片的结束位置
                long end = Math.min(start + linesPerSplit - 1, totalLines - 1);
                // 创建切片
                splits.add(new CustomInputSplit(path, start, end));
                start += linesPerSplit;
            }
        }

        return splits;
    }

    @Override
    public RecordReader<Text, LongWritable> createRecordReader(InputSplit split,
                                                               TaskAttemptContext taskAttemptContext) throws IOException {
        return new LineRecordReader();
    }

    // 实现countLines方法来统计文件行数
    private long countLines(Path path) throws IOException {
        // 这里需要实现统计文件行数的逻辑
        // 可以使用FileSystem API来读取文件并计数
        return 0; // 请替换为实际的行数
    }

    // 自定义InputSplit类
    public static class CustomInputSplit extends InputSplit {
        private Path path;
        private long start;
        private long end;

        public CustomInputSplit() {
        }

        public CustomInputSplit(Path path, long start, long end) {
            this.path = path;
            this.start = start;
            this.end = end;
        }

        @Override
        public long getLength() throws IOException {
            return (end - start) + 1;
        }

        @Override
        public String[] getLocations() throws IOException {
            // 返回文件所在的机架信息
            // 这里可以返回一个空数组，因为切片大小固定，不需要考虑机架信息
            return new String[0];
        }

        // 需要重写getReader方法来实现具体的读取逻辑
        @Override
        public RecordReader<LongWritable, Text> getRecordReader(TaskAttemptContext tac) throws IOException {
            // 这里需要实现如何根据start和end来读取文件的逻辑
            return null; // 请替换为实际的RecordReader
        }
    }
}
