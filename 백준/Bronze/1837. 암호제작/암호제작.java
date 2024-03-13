import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger p = new BigInteger(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[k + 1]; // false -> 소수
        prime[1] = true;

        for (int i = 2; i < k; i++) {
            if (!prime[i]) {
                BigInteger now = new BigInteger(Integer.toString(i));
                if (p.mod(now).equals(BigInteger.ZERO)) {
                    System.out.println("BAD " + now);
                    return;
                }
                for (int j = i + i; j < k; j += i) {
                    prime[i] = true;
                }
            }
        }
        System.out.println("GOOD");
    }

}
