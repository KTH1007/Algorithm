import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int[] arr = new int[26];
		Arrays.fill(arr, -1);

		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(arr[ch - 'a'] == -1) {
				arr[ch - 'a'] = i;
			}
		}
		for(int i=0; i<arr.length; i++) {
			bw.write(Integer.toString(arr[i]));
			bw.write(" ");
		}

		bw.flush();
		bw.close();

	}
}