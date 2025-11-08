import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int h = Integer.parseInt(tokens[1]);

        int[] dp = new int[h + 2];

        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(br.readLine());
            if (i % 2 == 1) { // 석순 아래에서 위로
                dp[1]++;
                dp[height + 1]--;
            } else { // 종유석 위에서 아래로
                int start = h - height + 1;
                dp[start]++;
                dp[h + 1]--;
            }
        }

        for (int i = 1; i <= h; i++) {
            dp[i] += dp[i - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= h; i++) {
            min = Math.min(min, dp[i]);
        }

        int count = 0;
        for (int i = 1; i <= h; i++) {
            if (dp[i] == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}
