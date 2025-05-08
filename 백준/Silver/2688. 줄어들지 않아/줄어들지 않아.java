import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        long[][] dp = new long[65][10];

        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long result = 0;
            for (int i = 0; i < 10; i++) {
                result += dp[n][i];
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }

}
