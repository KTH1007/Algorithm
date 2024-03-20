import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int n;
        BigInteger sum;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            br.readLine();
            n = Integer.parseInt(br.readLine());

            sum = BigInteger.ZERO;
            for (int i = 0; i < n; i++) {
                sum = sum.add(new BigInteger(br.readLine()));
            }
            if (sum.mod(new BigInteger(Integer.toString(n))).equals(BigInteger.ZERO)) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }

}
