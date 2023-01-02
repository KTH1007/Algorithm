import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		long[] arr = new long[36];
		arr[0] = 1;
		arr[1] = 1;
		for(int i=2; i<36; i++) {
			for(int j=0; j<i; j++) {
				arr[i] += arr[j]*arr[i-1-j];
			}
 		}
		System.out.println(arr[n]);
	}
}
