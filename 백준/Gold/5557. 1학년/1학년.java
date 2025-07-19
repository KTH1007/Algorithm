import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = Integer.parseInt(st.nextToken());


        long[][] dp = new long[n + 1][21];
        dp[1][arr[1]] = 1;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (j + arr[i + 1] <= 20) {
                    dp[i + 1][j + arr[i + 1]] += dp[i][j];
                }
                if (j - arr[i + 1] >= 0) {
                    dp[i + 1][j - arr[i + 1]] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n - 1][total]);
    }
}
