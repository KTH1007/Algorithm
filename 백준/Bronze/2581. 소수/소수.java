import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = m; i <= n; i++) {
            int a = isPrime(i);
            if (a != -1) {
                sum += a;
                min = Math.min(min, a);
            }
        }

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    static int isPrime(int n) {
        if (n == 1) return -1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return -1;
        }
        return n;
    }
}
