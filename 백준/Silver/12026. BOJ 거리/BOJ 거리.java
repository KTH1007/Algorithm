import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    if ((arr[i] == 'O' && arr[j] == 'B') || (arr[i] == 'J' && arr[j] == 'O') || (arr[i] == 'B' && arr[j] == 'J')) {
                        dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                    }
                }

            }
        }

        if (dp[n - 1] == Integer.MAX_VALUE) {
            dp[n - 1] = -1;
        }
        System.out.println(dp[n - 1]);
    }
}
