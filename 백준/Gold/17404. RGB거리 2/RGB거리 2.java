import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];

        String[] tokens;
        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            int[][] dp = new int[n][3];

            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[0][j] = arr[0][j];
                } else {
                    dp[0][j] = 1000000;
                }
            }

            for (int j = 1; j < n; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j - 1][1], dp[j - 1][0]) + arr[j][2];
            }

            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    min = Math.min(min, dp[n - 1][j]);
                }
            }
        }

        System.out.println(min);
    }
}
