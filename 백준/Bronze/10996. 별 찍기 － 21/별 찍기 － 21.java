import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n * 2; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    if (j % 2 == 0) sb.append("*");
                    else sb.append(" ");
                }
                sb.append("\n");
            } else {
                for (int j = 0; j < n; j++) {
                    if (j % 2 != 0) sb.append("*");
                    else sb.append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }


}
