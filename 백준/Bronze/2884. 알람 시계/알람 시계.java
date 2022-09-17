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
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		b -= 45;
		if(b < 0) {
			b = 60 + b;
			a--;
			if(a<0) {
				a = 23;
			}
		}
		bw.write(Integer.toString(a) + " ");
		bw.write(Integer.toString(b));
		bw.flush();
		bw.close();

	}
}