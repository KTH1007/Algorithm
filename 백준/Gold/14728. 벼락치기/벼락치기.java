import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]);
        int t = Integer.parseInt(tokens[1]);

        int[][] chapter = new int[n][2];

        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            chapter[i][0] = Integer.parseInt(tokens[0]);
            chapter[i][1] = Integer.parseInt(tokens[1]);
        }

        int[] dp = new int[t + 1];

        for (int i = 0; i < n; i++) {
            for (int j = t; j >= chapter[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - chapter[i][0]] + chapter[i][1]);
            }
        }

        System.out.println(dp[t]);
    }
}
