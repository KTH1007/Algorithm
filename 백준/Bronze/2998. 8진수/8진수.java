import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        BigInteger num = new BigInteger(str, 2);

        String answer = num.toString(8);

        sb.append(answer);
        System.out.println(sb.toString());
    }
}