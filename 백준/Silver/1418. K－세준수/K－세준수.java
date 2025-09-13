import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Boolean[] prime = new Boolean[n + 1];
        Arrays.fill(prime, true);
        isPrime(prime, n);

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (count(prime, i, k)) count++;
        }

        System.out.println(count + 1);
    }

    private static void isPrime(Boolean[] prime, int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i * i; j <= n ; j += i) {
                prime[j] = false;
            }
        }
    }

    private static boolean count(Boolean[] prime, int num, int k) {
        int max = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (prime[i]) {
                    max = Math.max(max, i);
                }
                if (prime[num / i]) {
                    max = Math.max(max, num / i);
                }
            }
        }

        if (max <= k) return true;
        return false;
    }
}
