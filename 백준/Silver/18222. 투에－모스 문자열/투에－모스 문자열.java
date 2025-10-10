import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        System.out.println(solve(k - 1));
    }

    private static int solve(long k) {
        if (k == 0) return 0;
        if (k == 1) return 1;

        long len = 1;
        while (len * 2 <= k) {
            len *= 2;
        }

        return 1 - solve(k - len);
    }
}
