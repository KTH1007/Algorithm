import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[101];

        for (int i = 0; i < 101; i++) {
            dp[i] = i;
        }

        for (int i = 7; i < 101; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
                dp[i] = Math.max(dp[i], dp[i - 2] + 2);
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
