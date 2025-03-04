import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int NUM = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] prime = new boolean[NUM + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        isPrime(prime);

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (prime[number]) count++;
        }

        System.out.println(count);
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
