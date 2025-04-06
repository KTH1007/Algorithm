import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[101][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[2][2] = 2;
        dp[2][3] = 2;
        dp[2][4] = 2;
        dp[2][5] = 2;
        dp[2][6] = 2;
        dp[2][7] = 2;
        dp[2][8] = 2;
        dp[2][9] = 1;

        dp[3][1] = 3;
        for (int i = 2; i < 8; i++) {
            dp[3][i] = 4;
        }
        dp[3][8] = 3;
        dp[3][9] = 2;

        for (int i = 3; i < 101; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
            dp[i][9] = dp[i - 1][8];
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[n][i]) % 1000000000;
        }

        System.out.println(answer);
    }
}
