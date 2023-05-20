package count_integral;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class Main {
	
	public static class IntegralMapper extends Mapper<LongWritable, Text, Text, DoubleWritable>{
		
		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();
			String[] args = line.split(",");
			double start = Double.parseDouble(args[0]);
			double end = Double.parseDouble(args[1]);
			
			double sum = calc(start, end);
			
			context.write(new Text("integral"), new DoubleWritable(sum));
		}

		private double calc(double start, double end) {
			double integral = ((f(start) + f(end))/2) * (end - start);
			return integral;
		}
	}
	
	public static double f(double x) {
		return x;
	}
	
	public static class IntegralReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
		
		@Override
		protected void reduce(Text key, Iterable<DoubleWritable> values, Context context)
				throws IOException, InterruptedException {
			double sum = 0;
			for (DoubleWritable val : values)
				sum += val.get();
			
			context.write(new Text("integral"), new DoubleWritable(sum));
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Job job = Job.getInstance();
		job.setJarByClass(Main.class);
		
		job.setMapperClass(IntegralMapper.class);
		job.setReducerClass(IntegralReducer.class);
		job.setCombinerClass(IntegralReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.waitForCompletion(true);
	}
}
