import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            sb.append("String #").append(i).append("\n");
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char c = (char) (s.charAt(j) + 1);
                if (c > 'Z') c = 'A';
                sb.append(c);
            }
            sb.append("\n").append("\n");
        }

        System.out.println(sb);
    }
}
