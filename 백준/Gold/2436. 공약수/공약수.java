import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");

        long gcd = Integer.parseInt(tokens[0]);
        long lcm = Integer.parseInt(tokens[1]);

        long min = Long.MAX_VALUE;
        long resultX = 0;
        long resultY = 0;
        long target = lcm / gcd;

        for (long i = 1; i * i <= target; i++) {
            if (target % i != 0) {
                continue;
            }
            long j = target / i;

            if (gcd(i, j) == 1) {
                long x = gcd * i;
                long y = gcd * j;

                if (x + y < min) {
                    resultX = x;
                    resultY = y;
                }
            }
        }

        System.out.println(resultX + " " + resultY);
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}
