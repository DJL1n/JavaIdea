package com.root.sort2;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.LineRecordReader;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class CustomInputFormat extends TextInputFormat {

    @Override
    protected boolean isSplitable(JobContext context, Path file) {
        return false;
    }

    @Override
    public RecordReader<LongWritable, Text> createRecordReader(InputSplit split, TaskAttemptContext context) {
        return new CustomRecordReader();
    }

    public static class CustomRecordReader extends RecordReader<LongWritable, Text> {
        private final LineRecordReader lineRecordReader = new LineRecordReader();
        private LongWritable currentKey = new LongWritable();
        private Text currentValue = new Text();
        private int linesPerSplit = 40;
        private int currentLineNumber = 0;

        @Override
        public void initialize(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {
            lineRecordReader.initialize(split, context);
        }

        @Override
        public boolean nextKeyValue() throws IOException {
            if (!lineRecordReader.nextKeyValue()) {
                return false;
            }
            currentKey.set(currentLineNumber / linesPerSplit);
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
