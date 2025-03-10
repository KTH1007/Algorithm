import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[m + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        isPrime(prime, m);

        int min = -1;
        int sum = 0;

        for (int i = n; i <= m; i++) {
            if (prime[i]) {
                sum += i;
                if (min == -1) min = i;
            }
        }

        if (min == -1) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    private static void isPrime(boolean[] prime, int m) {
        for (int i = 2; i <= Math.sqrt(m); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= m; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}
