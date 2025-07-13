import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int M = Integer.parseInt(st.nextToken());
			if(i == 0) {
				arr[0] = M;
			}else {
				arr[i] = (M * (i + 1)) - sum;
			}
			sum += arr[i];
		}
		for(int K : arr) {
			System.out.print(K + " ");
		}
	}

}