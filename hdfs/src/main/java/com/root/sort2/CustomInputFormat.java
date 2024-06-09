package com.root.sort2;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.input.LineRecordReader;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomInputFormat extends FileInputFormat<LongWritable, Text> {

    private static final int LINES_PER_SPLIT = 40;

    @Override
    public RecordReader<LongWritable, Text> createRecordReader(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {
        return new CustomRecordReader();
    }

    @Override
    public List<InputSplit> getSplits(JobContext job) throws IOException {
        List<InputSplit> splits = new ArrayList<>();
        Path[] paths = FileInputFormat.getInputPaths(job);
        FileSystem fs = FileSystem.get(job.getConfiguration());

        for (Path path : paths) {
            long length = fs.getFileStatus(path).getLen();
            long splitSize = LINES_PER_SPLIT;
            long numSplits = length / splitSize;
            for (long i = 0; i < numSplits; i++) {
                splits.add(new FileSplit(path, i * splitSize, splitSize, null));
            }
            // Handle the last split if the file length is not an exact multiple of splitSize
            if (length % splitSize != 0) {
                splits.add(new FileSplit(path, numSplits * splitSize, length - (numSplits * splitSize), null));
            }
        }
        return splits;
    }

    public static class CustomRecordReader extends RecordReader<LongWritable, Text> {
        private final LineRecordReader lineRecordReader = new LineRecordReader();
        private LongWritable currentKey = new LongWritable();
        private Text currentValue = new Text();
        private int currentLineNumber = 0;

        @Override
        public void initialize(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {
            lineRecordReader.initialize(split, context);
            System.out.println("Initializing split: " + split.toString());
        }

        @Override
        public boolean nextKeyValue() throws IOException {
            if (!lineRecordReader.nextKeyValue()) {
                return false;
            }
            currentKey.set(currentLineNumber);
            currentValue.set(lineRecordReader.getCurrentValue());
            currentLineNumber++;
            return true;
        }

        @Override
        public LongWritable getCurrentKey() {
            return currentKey;
        }

        @Override
        public Text getCurrentValue() {
            return currentValue;
        }

        @Override
        public float getProgress() throws IOException {
            return lineRecordReader.getProgress();
        }

        @Override
        public void close() throws IOException {
            lineRecordReader.close();
        }
    }
}
