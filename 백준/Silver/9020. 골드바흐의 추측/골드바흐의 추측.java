import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int NUM = 10000;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] prime = new boolean[NUM + 1];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;
        isPrime(prime);

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int a = 0;
            int b = Integer.MAX_VALUE;

            for (int i = 2; i <= n / 2; i++) {
                if (prime[i]) {
                    int temp = n - i;
                    if (prime[temp] && b - a > temp - i) {
                        a = i;
                        b = temp;
                    }
                }
            }
            sb.append(a).append(" ").append(b).append("\n");
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
