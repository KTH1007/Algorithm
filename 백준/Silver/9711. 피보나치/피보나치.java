import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        dp = new long[10001];
        dp[0] = 0;
        dp[1] = 1;
        int p, q;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            for (int j = 2; j <= p; j++) {
                dp[j] = (dp[j - 2] + dp[j - 1]) % q;
            }
            sb.append("Case #").append(i).append(": ").append(dp[p] % q).append("\n");
        }
        System.out.println(sb);
    }


}