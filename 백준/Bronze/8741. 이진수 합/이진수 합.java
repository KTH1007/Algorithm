import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        BigInteger index = BigInteger.TWO.pow(num).subtract(BigInteger.ONE);

        BigInteger sum = index.multiply(index.add(BigInteger.ONE)).divide(BigInteger.TWO);

        String answer = sum.toString(2);

        sb.append(answer);
        System.out.println(sb.toString());
    }
}
