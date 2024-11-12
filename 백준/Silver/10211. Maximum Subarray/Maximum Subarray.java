import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n];

            st = new StringTokenizer(br.readLine());
            dp[0] = Integer.parseInt(st.nextToken());
            int max = dp[0];
            for (int i = 1; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                dp[i] = Math.max(dp[i - 1] + num, num);
                max = Math.max(max, dp[i]);
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }

}
