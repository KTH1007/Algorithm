import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //n의 값, 마지막 연산의 숫자
        long[][] dp = new long[100001][4];
        dp[1][1] = 1; //1
        dp[2][2] = 1; //2
        dp[3][1] = 1; //2+1
        dp[3][2] = 1; //1+2
        dp[3][3] = 1; //3

        /**
         * dp[n][1]의 경우 직전 값이 n-1이 되어야 하고 마지막 값이 1이면 안 된다.
         * 즉 dp[n-1][1]은 안 되고 dp[n-1][2] + dp[n-1][3]을 더해야 한다.
         * dp[n][2]의 경우 직전 값이 n-2이고 마지막 값이 2이면 안 된다.
         * -> dp[n-2][1] + dp[n-2][3]
         */

        for (int i = 4; i < 100001; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
        }

        int t = Integer.parseInt(br.readLine());

        long sum = 0;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sum = (dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009;
            sb.append(sum).append("\n");
        }

        System.out.println(sb);


    }

}