import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.io.*;

public class solution {

	public static void addComma(String in, String out) throws Exception {
		File inputFile = new File(in);
		System.out.println(inputFile);
		File outputFile = new File(out);
		Scanner Reader = new Scanner(inputFile);
		FileWriter write = new FileWriter(outputFile);
		write.write(Reader.nextLine() + "\n");
		int c = 1;
		while (Reader.hasNext()) {
			c++;
			String s = Reader.nextLine();
			String word = "";
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != ' ' && s.charAt(i) != '+') {
					word += s.charAt(i);
				} else if (word.length() > 0) {
					count++;
					if (count == 3) {
						write.write(word + "\n");
						break;
					} else {
						write.write(word + ",	     ");
					}
					word = "";
				}
			}
		}
		System.out.println(c);
	}

	static double T_check(double u, double sigma, double k) {
		return u / Math.sqrt(1 / k + 1.0 / 9) / sigma;
	}

	static double entropy(double p) {

		return -p * (Math.log10(p) / Math.log(2)) - (1 - p)
				* (Math.log10(1 - p) / Math.log(2));
	}

	static void spilit(int[] bits, int n) {
		int k = bits.length;
		while (k > 0) {
			if (n > 0) {
				while (n > 0) {
					k--;
					bits[k] = n % 2;
					n /= 2;
				}
			} else {
				k--;
				bits[k] = 0;
			}
		}
	}

	public class HW3ML {
		
		public HW3ML(){
			
		}
		public int OR(int[] bits) {
			int res = 0;
			for (int i = 0; i < bits.length; i++) {
				res |= bits[i];
			}
			return res;
		}

		public int XOR(int[] bits) {
			int res = 0;
			for (int i = 0; i < bits.length; i++) {
				res ^= bits[i];
			}
			return res;
		}
		
		public int Majority(int[] bits){
			int count1 = 0, count0 = 0;
			for(int i = 0; i < bits.length; i++){
				if (bits[i] == 0){
					count0++;
				}
				else{
					count1++;
				}
			}
			if (count0 > count1){
				return 0;
			}
			else{
				return 1;
			}
		}
		
		public int Parity(int[] bits){
			int count0 = 0;
			for(int i = 0; i < bits.length; i++){
				if (bits[i] == 0){
					count0++;
				}
			}
			if (count0 % 2 == 1){
				return 0;
			}
			else{
				return 1;
			}
		}
	}

	static void mlhw3b_binarydata_generation(int n, String outputFile)
			throws IOException {
		solution s = new solution();
		File path = new File(outputFile);
		Writer out = new FileWriter(path);
		HW3ML method = s.new HW3ML();
		int N = (int) Math.pow(2, n);
		int bits[] = new int[n];
		for (int j = n - 1; j >= 0; j--) {
			// System.out.print(bits[j]);
			out.write("bits" + j + ",   ");
		}
		out.write("answer" + "\n");
		for (int i = 0; i < N; i++) {
			spilit(bits, i);
			for (int j = 0; j < n; j++) {
				// System.out.print(bits[j]);
				out.write(bits[j] + " ");
			}
			// System.out.println();
			out.write((method.Majority(bits) == 0 ? 0:1) + "\n");

		}
		out.close();
	}

	public static void main(String[] Args) throws Exception {
		// System.out.println(entropy(0.2));
		// addComma("/Users/mac/Documents/workspace/Leetcode/ML_helper/src/5.txt","/Users/mac/Documents/workspace/Leetcode/ML_helper/src/55.txt");
		// System.out.println(T_check(4.43, 4.04, 474433));
		mlhw3b_binarydata_generation(5, "Parity.txt");
		System.out.print("success!");
	}
}
