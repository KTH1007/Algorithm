import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[100000 + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;

        for (int i = 5; i <= n; i++) {
            if (i == Math.pow((int) Math.sqrt(i), 2)) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + 1;
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
                }
            }
        }

        System.out.println(dp[n]);
    }

}
