import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        // 동전 1, 2, 5, 7
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2; // 1, 2
        dp[4] = 2; // 2, 2
        dp[5] = 1;
        dp[6] = 2; // 1, 5
        dp[7] = 1;
        dp[8] = 2; // 1, 7
        dp[9] = 2; // 2, 7
        dp[10] = 2; // 5, 5
        dp[11] = 3; //1, 5, 5   2, 2, 7
        for (int i = 12; i <= n; i++) {
            dp[i] = Math.min(Math.min(dp[i - 1], dp[i - 2]), Math.min(dp[i - 5], dp[i - 7])) + 1;
        }
        System.out.println(dp[n]);
    }


}
