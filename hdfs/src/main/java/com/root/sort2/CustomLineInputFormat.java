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

public class CustomLineInputFormat extends TextInputFormat {

    @Override
    protected boolean isSplitable(JobContext context, Path file) {
        return false;
    }

    @Override
    public List<InputSplit> getSplits(JobContext job) throws IOException {
        List<InputSplit> splits = super.getSplits(job);
        int linesPerSplit = 40; // 每40行一个切片
        List<InputSplit> customSplits = new ArrayList<>();

        for (InputSplit split : splits) {
            Path file = ((FileInputFormat.FileSplit) split).getPath();
            long start = split.getStart();
            long length = split.getLength();
            long fileLength = file.getFileSystem(job.getConfiguration()).getFileStatus(file).getLen();
            long end = Math.min(start + length, fileLength);

            // 计算每个切片的起始和结束位置
            long current = start;
            while (current < end) {
                long next = current + Math.min(linesPerSplit, (end - current)) * LineRecordReader.LINE_RECORD_LENGTH;
                customSplits.add(new FileInputFormat.FileSplit(file, current, next - current, (String[]) null));
                current = next;
            }
        }

        return customSplits;
    }
}
