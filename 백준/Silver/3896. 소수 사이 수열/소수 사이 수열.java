import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int NUM = 1299709;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] prime = new boolean[NUM + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        isPrime(prime);

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int k =Integer.parseInt(br.readLine());
            if (prime[k]) {
                sb.append(0).append("\n");
                continue;
            }

            int left = 0;
            int right = 0;

            for (int i = k - 1; i >= 2; i--) {
                if (prime[i]) {
                    left = i;
                    break;
                }
            }

            for (int i = k + 1; i <= NUM; i++) {
                if (prime[i]) {
                    right = i;
                    break;
                }
            }

            sb.append(right - left).append("\n");
        }

        System.out.println(sb);
    }

    private static void isPrime(boolean[] prime) {
        for (int i = 2; i <= Math.sqrt(NUM); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= NUM; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}
