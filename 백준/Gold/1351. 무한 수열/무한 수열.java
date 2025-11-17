import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        long n = Long.parseLong(tokens[0]);
        long p = Long.parseLong(tokens[1]);
        long q = Long.parseLong(tokens[2]);

        Map<Long, Long> dp = new HashMap<>();
        dp.put(0L, 1L);

        long result = solve(n, p, q, dp);
        System.out.println(result);
    }

    private static long solve(long n, long p, long q, Map<Long, Long> dp) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        long result = solve(n / p, p, q, dp) + solve(n / q, p, q, dp);
        dp.put(n, result);
        return result;
    }
}
