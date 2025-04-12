import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int SIZE = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] prime = new boolean[SIZE + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        isPrime(prime);

        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;

            int a = 2;
            while (a <= num / 2) {
                if (prime[a] && prime[num - a]) {
                    sb.append(num).append(" = ").append(a).append(" + ").append(num - a).append("\n");
                    break;
                }
                a++;
                if (a > num / 2) sb.append("Goldbach's conjecture is wrong").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void isPrime(boolean[] prime) {
        for (int i = 2; i <= Math.sqrt(SIZE); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= SIZE ; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}
