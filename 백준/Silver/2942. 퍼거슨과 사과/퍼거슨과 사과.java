import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        int max = gcd(r, g);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= max; i++) {
            if (check(r, g, i)) {
                sb.append(i).append(" ").append(r / i).append(" ").append(g / i).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static boolean check(int r, int g, int i) {
        return r % i == 0 && g % i == 0;
    }
}
