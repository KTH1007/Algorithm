import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[100001];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        isPrime(prime);

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 2; i <= n; i++) {
                if (prime[i]) {
                    while (n % i == 0) {
                        count++;
                        n /= i;
                    }
                }
                if (count != 0) {
                    sb.append(i).append(" ").append(count).append("\n");
                    count = 0;
                }
            }
        }

        System.out.println(sb);

    }

    private static void isPrime(boolean[] prime) {
        for (int i = 2; i <= Math.sqrt(100001); i++) {
            if (prime[i]) {
                for (int j = i * i; j < 100001; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

}
