import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger k = new BigInteger(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[l + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i < l; i++) {
            if (!prime[i]) {
                BigInteger now = new BigInteger(Integer.toString(i));
                if (k.mod(now).equals(BigInteger.ZERO)) {
                    System.out.println("BAD " + now);
                    return;
                }
                for (int j = i + i; j < l; j += i) {
                    prime[j] = true;
                }
            }
        }
        System.out.println("GOOD");
    }

}
