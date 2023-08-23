import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new int[11];
        dp[1] = 0;
        dp[2] = 1;
//        dp[3] = 3;  // 2 1   2 ->  1  1  2 + 1
//        dp[4] = 6;  // 2  2 -> 4  4 + 1 + 1
//        dp[5] = 10;  // 3  2  ->6    3->3   2->1    6 + 3 + 1
//        dp[8] = 28; // 4 4  -> 16  16 + 6 + 6
        for (int i = 3; i <= n; i++) {
            dp[i] = i/2 * (i- (i/2)) + dp[i/2] + dp[i-(i/2)];
        }
        System.out.println(dp[n]);
    }


}