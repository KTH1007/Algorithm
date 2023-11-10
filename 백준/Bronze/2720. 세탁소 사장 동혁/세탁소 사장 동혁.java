import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(n / 25).append(" ");
            n %= 25;
            sb.append(n / 10).append(" ");
            n %= 10;
            sb.append(n / 5).append(" ");
            n %= 5;
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }


}
