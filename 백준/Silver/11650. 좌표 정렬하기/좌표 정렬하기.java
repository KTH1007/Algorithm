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
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int j=0;
			arr[i][j] = a;
			arr[i][j+1] = b;
		}
		Arrays.sort(arr, (o1,o2) -> {
			if(o1[0] == o2[0]) {
				return Integer.compare(o1[1],o2[1]);
			}
			else {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<2; j++) {
				bw.write(Integer.toString(arr[i][j]));
				bw.write(" ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();

	}
}