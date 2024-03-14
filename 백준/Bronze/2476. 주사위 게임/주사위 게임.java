import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int a, b, c;
        int max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == b && b == c) max = Math.max(max, a * 1000 + 10000);
            else if (a == b && a != c) max = Math.max(max, a * 100 + 1000);
            else if (a == c && a != b) max = Math.max(max, a * 100 + 1000);
            else if (b == c && a != b) max = Math.max(max, b * 100 + 1000);
            else max = Math.max(max, Math.max(a, Math.max(b, c)) * 100);
        }

        System.out.println(max);
    }

}
