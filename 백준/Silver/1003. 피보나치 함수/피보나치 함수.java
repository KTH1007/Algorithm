import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static Integer[][] dp = new Integer[41][2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		dp[0][0] = 1; //n이 0일 때 0의 호출 횟수
		dp[0][1] = 0; //n이 0일 때 1의 호출 횟수
		dp[1][0] = 0; //n이 1일 때 0의 호출 횟수
		dp[1][1] = 1; //n이 1일 때 1의 호출 횟수
		for(int i=0; i<n; i++) {
			int a = Integer.parseInt(br.readLine());
			fibo(a);
			sb.append(dp[a][0] + " " + dp[a][1]+"\n");
		}
		System.out.println(sb);
	}
	public static Integer[] fibo(int n) {
		if(dp[n][0] == null || dp[n][1] == null) {
			dp[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
			dp[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
		}
		return dp[n];
	}
}
