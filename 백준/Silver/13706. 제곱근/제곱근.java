import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n = new BigInteger(br.readLine());
        BigInteger end = n;
        BigInteger start = new BigInteger("1");
        BigInteger mid;

        while (true) {
            mid = start.add(end);
            mid = mid.divide(new BigInteger("2"));

            int result = mid.multiply(mid).compareTo(n);

            if (result == 0) {
                System.out.println(mid);
                break;
            } else if (result == 1) {
                end = mid.subtract(new BigInteger("1"));
            } else {
                start = mid.add(new BigInteger("1"));
            }
        }
    }
}
