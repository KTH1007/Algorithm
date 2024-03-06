import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int share = n / 5;
            int remainder = n % 5;

            for (int i = 0; i < share; i++) sb.append("++++ ");
            for (int i = 0; i < remainder; i++) sb.append("|");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
