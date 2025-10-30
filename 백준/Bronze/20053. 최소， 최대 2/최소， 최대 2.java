import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] list = new int[N];
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int j = 0; j < list.length; j++) {
				list[j] = Integer.parseInt(token.nextToken());
			}
			Arrays.sort(list);
			bw.write(list[0] + " " + list[N - 1] + "\n");
		}
		bw.flush();
		bw.close();
	}

}