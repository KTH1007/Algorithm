import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        /**
         * 0 1 2 ...
         * 1 1 1 1 1 1 1 1 1 1
         */
        /**
         * 00 ~ 09 11 ~ 19 ...
         * 10 9 8 7 6 5 4 3 2 1
         */

        /**
         * 001 002... -> 55
         * 011 012 ... -> 45
         *
         * 55 45 ...
         */

        // j번째 수는 n - 1에서 j부터 9까지 합
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += (dp[i - 1][k] % 10007);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += (dp[n][i] % 10007);
        }

        System.out.println(answer % 10007);
    }
}
