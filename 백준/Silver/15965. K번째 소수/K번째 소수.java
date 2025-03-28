import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static final int N = 500000;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[N + 1];


        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        
        isPrime(prime);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            if (prime[i]) {
                list.add(i);
            }
        }

        System.out.println(list.get(n - 1));
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
