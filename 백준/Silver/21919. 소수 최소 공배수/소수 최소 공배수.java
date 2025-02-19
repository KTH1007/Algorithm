import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static final int NUM = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] prime = new boolean[NUM + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        isPrime(prime);

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (prime[arr[i]]) {
                set.add(arr[i]);
            }
        }

        if (set.isEmpty()) {
            System.out.println(-1);
            return;
        }

        long lcm = 1;
        for (Integer i : set) {
            lcm *= i;
        }

        System.out.println(lcm);
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
