import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine());
        /**
         0 정보과학관
         1 진선관
         2 미래관
         3 신양관
         4 진리관
         5 환경직기념관
         6 학생회관
         7 형남공학관
         */
        long[][] dp = new long[d + 1][8];
        dp[0][0] = 1;

        for (int i = 1; i <= d; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % 1000000007;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2] + dp[i - 1][3]) % 1000000007;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5]) % 1000000007;
            dp[i][3] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4] + dp[i - 1][5]) % 1000000007;
            dp[i][4] = (dp[i - 1][3] + dp[i - 1][5] + dp[i - 1][6]) % 1000000007;
            dp[i][5] = (dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][7]) % 1000000007;
            dp[i][6] = (dp[i - 1][4] + dp[i - 1][7]) % 1000000007;
            dp[i][7] = (dp[i - 1][5] + dp[i - 1][6]) % 1000000007;
        }
        System.out.println(dp[d][0]);
    }


}
