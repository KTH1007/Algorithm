import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        String d = st.nextToken();

        boolean[] prime = new boolean[b + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        int count = 0;
        isPrime(prime, b);

        for (int i = a; i <= b; i++) {
            if (prime[i]) {
                String str = String.valueOf(i);
                if (str.contains(d)) count++;
            }
        }

        System.out.println(count);
    }

    private static void isPrime(boolean[] prime, int b) {
        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= b; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}
