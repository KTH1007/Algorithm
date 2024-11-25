import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int a = 0;
        int b = n - 1;
        int c = 3 * n - 3;
        int d = 4 * n - 4;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 2 * n - 1; i++) {
            if (i == 1 || i == 2 * n - 1) {
                for (int j = a; j <= b; j++) {
                    sb.append("*");
                }
                for (int j = b + 1; j < c; j++) {
                    sb.append(" ");
                }
                for (int j = c; j <= d; j++) {
                    sb.append("*");
                }
            } else {
                for (int j = 0; j < a; j++) {
                    sb.append(" ");
                }
                sb.append("*");
                for (int j = a + 1; j < b; j++) {
                    sb.append(" ");
                }
                sb.append("*");
                for (int j = b + 1; j < c; j++) {
                    sb.append(" ");
                }
                if (b != c) sb.append("*");
                for (int j = c + 1; j < d; j++) {
                    sb.append(" ");
                }
                sb.append("*");
            }
            sb.append("\n");

            if (i < n) {
                a++;
                b++;
                c--;
                d--;
            } else {
                a--;
                b--;
                c++;
                d++;
            }
        }
        System.out.println(sb);
    }
}
