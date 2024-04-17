import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        dp[1] = 5;
        int minus = 3;
        for (int i = 2; i <= n; i++) {
            dp[i] = ((5 * i) + dp[i - 1] - (minus)) % 45678;
            minus += 2;
        }
        System.out.println(dp[n]);
    }
}
