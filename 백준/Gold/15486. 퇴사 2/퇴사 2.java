import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 2][2];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 2];

        int max = -1;

        for (int i = 1; i <= n + 1; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }

            int next = i + arr[i][0];
            if (next < n + 2) {
                dp[next] = Math.max(dp[next], max + arr[i][1]);
            }
        }

        System.out.println(max);
    }
}
