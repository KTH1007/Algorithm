import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 3; t++) {
            int n = Integer.parseInt(br.readLine());
            BigInteger big = new BigInteger("0");
            for (int i = 0; i < n; i++) {
                big = big.add(new BigInteger(br.readLine()));
            }

            String temp = big.toString();
            if (temp.charAt(0) == '0') sb.append(0).append("\n");
            else if (temp.charAt(0) == '-') sb.append("-").append("\n");
            else sb.append("+").append("\n");

        }
        System.out.println(sb);
    }


}
