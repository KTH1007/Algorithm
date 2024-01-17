import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int k = Integer.parseInt(br.readLine());
            while (k-- > 0) sb.append("=");
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
