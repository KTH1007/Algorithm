import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;  //3을 나타내는 방법 1+1+1,  1+2, 2+1, 3
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 4; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
            }
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }

}
