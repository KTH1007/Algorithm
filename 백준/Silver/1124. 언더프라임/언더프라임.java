import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] prime = new boolean[100001];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        isPrime(prime);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = a; i <= b; i++) {
            int count = 0;
            int num = i;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (prime[j]) {
                    while (num % j == 0) {
                        count++;
                        num /= j;
                    }
                }
            }

            if (num > 1) {
                count++;
            }

            if (prime[count]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void isPrime(boolean[] prime) {
        for (int i = 2; i <= Math.sqrt(100000) ; i++) {
            if (prime[i]) {
                for (int j = i * i; j < 100001; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

}
