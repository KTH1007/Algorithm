import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += (int) Math.pow(Integer.parseInt(st.nextToken()),2);
		}
		bw.write(Integer.toString(sum%10));
		bw.flush();
		bw.close();

	}
}
