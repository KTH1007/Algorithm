import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int N = 90000000;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[N + 1];

        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        isPrime(prime);

        int[] arr = new int[N + 1];
        int idx = 0;
        for (int i = 0; i <= N; i++) {
            if (prime[i]) {
                arr[idx++] = i;
            }
        }

        System.out.println(arr[n - 1]);
    }

    private static void isPrime(boolean[] prime) {
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= N; j +=i) {
                    prime[j] = false;
                }
            }
        }
    }
}
