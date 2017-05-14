import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
 
class SurveyAnalysis {
 
	private static PrintWriter out = new PrintWriter(System.out);
	private static InputStreamReader in;
 
	public static void main(String args[]) throws Exception {
		InputStream is = SurveyAnalysis.class.getResourceAsStream(SurveyAnalysis.class.getSimpleName() + ".in");
		boolean testMode = is != null;
		in = new InputStreamReader(testMode ? is : System.in);
 
		long start = System.currentTimeMillis();
		main();
 
		if (testMode) {
			out.println();
			out.print(System.currentTimeMillis() - start + " ms");
		}
 
		out.close();
	}
 
	private static class InputStreamReader {
		private byte[] buf = new byte[1 << 8];
		private int curChar;
		private int charsRead;
		private InputStream stream;
 
		public InputStreamReader(InputStream stream) {
			this.stream = stream;
		}
 
		private char read() throws IOException {
			if (charsRead == -1)
				throw new InputMismatchException();
			if (curChar >= charsRead) {
				curChar = 0;
				charsRead = stream.read(buf);
				if (charsRead <= 0)
					return (char) -1;
			}
			return (char) buf[curChar++];
		}
 
		private static boolean skip(int c) {
			return c != '1' && c != '0';
		}
	}
 
	private static void main() throws Exception {
		double mean = 0.0;
		int[] vals = new int[7];
		for (int i = 0; i < vals.length; ++i) {
			char c = '\n';
			while (InputStreamReader.skip(c))
				c = in.read();
			int count = 0;
			for (; !InputStreamReader.skip(c); c = in.read()) {
				count += c - '0';
			}
			mean += count;
			vals[i] = count;
		}
		mean /= vals.length;
		System.out.println(mean);
		double var = 0.0;
		for (int i = 0; i < vals.length; i++) {
			double diff = vals[i] - mean;
			var += diff * diff;
		}
		var /= vals.length;
		
		out.println(String.format("%.4f", Math.sqrt(var)));
	}
 
}