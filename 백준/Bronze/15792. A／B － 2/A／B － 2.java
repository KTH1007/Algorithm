import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(a / b).append(".");
        a = 10 * (a % b);
        int t = 1000;
        while (t-- > 0) {
            sb.append(a / b);
            a = 10 * (a % b);
        }

        System.out.println(sb);
    }

}
