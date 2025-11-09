import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[][] dp = new int [4][10001];
        for (int i = 0; i < 4; i++) {

        }

        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;

        dp[2][1] = 1;
        dp[2][2] = 2;
        dp[2][3] = 2;

        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 3;

        for (int i = 4; i < 10001; i++) {
            dp[1][i] = 1;
            dp[2][i] = dp[2][i - 2] + dp[1][i];
            dp[3][i] = dp[3][i - 3] + dp[2][i];
        }
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[3][n]).append("\n");
        }

        System.out.println(sb);
    }
}
