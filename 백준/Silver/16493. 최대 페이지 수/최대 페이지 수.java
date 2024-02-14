import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m + 1][2];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            //소요일
            arr[i][0] = Integer.parseInt(st.nextToken());
            //챕터수
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < arr[i][0]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i][0]] + arr[i][1]);
            }
        }

        System.out.println(dp[m][n]);

    }


}
