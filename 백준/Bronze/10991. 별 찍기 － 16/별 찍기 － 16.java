import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int count = n - 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < count; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i; j++) {
                sb.append("* ");
            }
            sb.append("\n");

            count--;
        }

        System.out.println(sb);

    }
}
