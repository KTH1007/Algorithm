import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);

        for (int i = 0; i < m; i++) {
            arr[Integer.parseInt(br.readLine())] = false;
        }

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int answer = 1;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!arr[i]) {
                answer *= dp[count];
                count = 0;
                continue;
            } else if (i == n) {
                count++;
                answer *= dp[count];
            }

            count++;
        }

        System.out.println(answer);
    }

}
