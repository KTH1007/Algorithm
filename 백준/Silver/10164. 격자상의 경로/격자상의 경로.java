import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][m + 1];

        int kx = -1;
        int ky = -1;

        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (count == k) {
                    kx = i;
                    ky = j;
                }
                count++;
                dp[i][j] = -1;
            }
        }

        if (k == 0) {
            System.out.println(recursion(1, 1, n, m, dp));
        } else {
            System.out.println(recursion(1, 1, kx, ky, dp) * recursion(kx, ky, n, m, dp));
        }

    }

    private static int recursion(int x, int y, int n, int m, int[][] dp) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (x == n && y == m) {
            return 1;
        }

        dp[x][y] = 0;
        if (x < n && y <= m) {
            dp[x][y] += recursion(x + 1, y, n, m, dp);
        }

        if (y < m && x <= n) {
            dp[x][y] += recursion(x, y + 1, n, m, dp);
        }

        return dp[x][y];
    }
}
