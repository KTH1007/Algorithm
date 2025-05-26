import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BigInteger a = new BigInteger("1");
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a = a.multiply(new BigInteger(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        BigInteger b = new BigInteger("1");
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b = b.multiply(new BigInteger(st.nextToken()));
        }

        BigInteger temp = gcd(a, b);
        String str = temp.toString();

        if (str.length() > 9) {
            str = str.substring(str.length() - 9);
        }

        System.out.println(str);
    }
    private static BigInteger gcd(BigInteger a, BigInteger b) {
        if (b == BigInteger.ZERO) return a;
        return gcd(b, a.remainder(b));
    }

}
