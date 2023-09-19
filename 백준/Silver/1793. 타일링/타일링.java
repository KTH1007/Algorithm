import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BigInteger[] dp = new BigInteger[251];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");
        dp[3] = new BigInteger("5");
        dp[4] = new BigInteger("11");
        for (int i = 3; i <= 250; i++) {
            dp[i] = dp[i - 2].multiply(new BigInteger("2")).add(dp[i - 1]);
        }

        String s;
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            int n = Integer.parseInt(s);
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }


}


