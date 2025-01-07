import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int temp = n;
        while (n > 0) {
            for (int i = 0; i < temp - n; i++) {
                sb.append(" ");
            }
            for (int i = 0; i < n; i++) {
                sb.append("*");
            }
            n--;
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
