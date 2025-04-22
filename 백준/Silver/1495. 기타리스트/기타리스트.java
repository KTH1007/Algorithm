import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, s, m;
    static int[] v;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        v = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[n + 1][m + 1];
        dp[0][s] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                if (!dp[i][j]) continue;

                if (j + v[i] <= m) {
                    dp[i + 1][j + v[i]] = true;
                }
                if (j - v[i] >= 0) {
                    dp[i + 1][j - v[i]] = true;
                }
            }
        }

        int answer = -1;
        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);

    }

}
