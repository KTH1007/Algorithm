import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s == null || s.equals("")) break;
            long num = Long.parseLong(s);

            if (num < 2) {
                sb.append(2).append("\n");
                continue;
            }

            while (true) {
                if (isPrime(num)) {
                    sb.append(num).append("\n");
                    break;
                }
                num++;
            }
        }

        System.out.println(sb);
    }

    private static boolean isPrime(long num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
