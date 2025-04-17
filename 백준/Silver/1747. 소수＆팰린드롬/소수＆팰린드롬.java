import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[SIZE + 1];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;
        isPrime(prime);

        while (true) {
            if (prime[n] && isPal(n)) {
                System.out.println(n);
                break;
            } else n++;
        }
    }

    private static void isPrime(boolean[] prime) {
        for (int i = 2; i <= Math.sqrt(SIZE); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= SIZE; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    private static boolean isPal(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        String str1 = sb.toString();
        String str2 = sb.reverse().toString();

        return str1.equals(str2);
    }

}
