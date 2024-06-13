import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BigInteger fac = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            fac = fac.multiply(new BigInteger(String.valueOf(i)));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(fac.toString());
        String s = sb.reverse().toString();

        int answer = countZero(s);
        System.out.println(answer);
    }

    public static int countZero(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') count++;
            else break;
        }
        return count;
    }

}
