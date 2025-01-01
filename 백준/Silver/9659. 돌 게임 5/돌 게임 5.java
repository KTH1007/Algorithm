import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());

        if (n.remainder(BigInteger.TWO).equals(BigInteger.ZERO)) {
            System.out.println("CY");
        } else System.out.println("SK");
    }

}
