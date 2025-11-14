import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] tokens = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }

        int[][] dp = new int[2][n];
        dp[0][0] = arr[0];
        dp[1][0] = 0;

        int max = arr[0];

        for (int i = 1; i < n; i++) {
            // 제거 안 한 경우
            dp[0][i] = Math.max(dp[0][i - 1] + arr[i], arr[i]);

            // i를 포함하면서 1개 제거
            dp[1][i] = dp[0][i - 1]; // i-1까지 + i 제거

            if (i >= 1) {
                dp[1][i] = Math.max(dp[1][i], dp[1][i - 1] + arr[i]); // 이전에 제거
            }

            if (i >= 2) {
                dp[1][i] = Math.max(dp[1][i], dp[0][i - 2] + arr[i]); // i-1 제거
            }

            max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
        }

        System.out.println(max);
    }
}
