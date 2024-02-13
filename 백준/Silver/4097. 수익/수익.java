import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                dp[i] = Integer.parseInt(br.readLine());
            }

            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                dp[i] = Math.max(dp[i], dp[i] + dp[i - 1]);
                max = Math.max(max, dp[i]);
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }


}
