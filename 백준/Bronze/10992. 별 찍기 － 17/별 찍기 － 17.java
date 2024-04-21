import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int count = n - 1;

        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                sb.append(" ");
            }
            if (i == n) {
                for (int j = 0; j < 2 * i - 1; j++) {
                    sb.append("*");
                }
            } else {
                for (int j = 0; j < 2 * i - 1; j++) {
                    if (j == 0 || j == 2 * i - 1 - 1) {
                        sb.append("*");
                    } else sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
