import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        BigInteger[] dp = new BigInteger[n + 2];

        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.ONE;


        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2].add(dp[i - 1]);
        }

        System.out.println(dp[n]);
    }

}
