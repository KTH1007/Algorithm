import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        long[] dp = new long[10001];
        for (int i = 1; i < m; i++) {
            dp[i] = 1;
        }

        dp[m] = 2;

        for (int i = m + 1; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - m]) % 1000000007;
        }

        System.out.println(dp[n]);
    }
}
