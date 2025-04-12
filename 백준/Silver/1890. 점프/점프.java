import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n + 1][n + 1];

        int next = arr[1][1];
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] >= 1 && !(i == n && j == n)) {
                    next = arr[i][j];
                    if (i + next <= n) dp[i + next][j] += dp[i][j];
                    if (j + next <= n) dp[i][j + next] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n][n]);
    }
}
