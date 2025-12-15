import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int count = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int candy = Integer.parseInt(st.nextToken());
				count += candy / K;
			}
			System.out.println(count);
		}
	}

}