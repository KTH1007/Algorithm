import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BigInteger n, m;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = new BigInteger(st.nextToken());
            m = new BigInteger(st.nextToken());
            if (n.equals(BigInteger.ZERO) && m.equals(BigInteger.ZERO)) {
                break;
            }
            BigInteger fib1 = BigInteger.ONE;
            BigInteger fib2 = BigInteger.TWO;
            BigInteger fib3 = BigInteger.ZERO;
            while (fib1.compareTo(m) <= 0) {
                if (fib1.compareTo(n) >= 0 && fib1.compareTo(m) <= 0) {
                    count++;
                }
                fib3 = fib1.add(fib2);
                fib1 = fib2;
                fib2 = fib3;
            }
            sb.append(count).append("\n");


        }
        System.out.println(sb);

    }


}