import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int NUM = 246912;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] prime = new boolean[NUM + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        isPrime(prime);

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (prime[i]) count++;
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static void isPrime(boolean[] prime) {
        for (int i = 2; i <= Math.sqrt(NUM); i++) {
            if (!prime[i]) continue;

            for (int j = i * i; j <= NUM; j += i) {
                prime[j] = false;
            }
        }
    }
}
