import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger[] fibo = new BigInteger[68];
        fibo[0] = BigInteger.ONE;
        fibo[1] = BigInteger.ONE;
        fibo[2] = BigInteger.TWO;
        fibo[3] = new BigInteger("4");

        for (int i = 4; i <= 67; i++) {
            fibo[i] = fibo[i - 1].add(fibo[i - 2]).add(fibo[i - 3]).add(fibo[i - 4]);
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(fibo[n]).append("\n");
        }

        System.out.println(sb);
    }
}
