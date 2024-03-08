import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int next = n + 1;
            if (next % (n % 100) == 0) sb.append("Good").append("\n");
            else sb.append("Bye").append("\n");
        }

        System.out.println(sb);
    }
}
