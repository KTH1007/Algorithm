import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r, c, w;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        dp = new int[r + w + 1][r + w + 1];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;
        for (int i = 4; i <= r + w; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        int sum = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j <= i; j++) {
                sum += dp[r + i][c + j];
            }
        }
        System.out.println(sum);
    }


}
