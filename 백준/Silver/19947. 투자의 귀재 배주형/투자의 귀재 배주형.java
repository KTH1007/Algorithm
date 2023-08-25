import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int h, y;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        dp = new int[y + 1];
        dp[0] = h;
        for (int i = 1; i <= y; i++) {
            dp[i] = (int) (dp[i-1] * 1.05);
            if (i >= 3) {
                dp[i] = Math.max((int) (dp[i - 3] * 1.2), dp[i]);
            }
            if (i >= 5) {
                dp[i] = Math.max((int) (dp[i - 5] * 1.35), dp[i]);
            }
        }
        System.out.println(dp[y]);
    }


}