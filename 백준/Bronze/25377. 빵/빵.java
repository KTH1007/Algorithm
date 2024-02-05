import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int min = Integer.MAX_VALUE;
        ;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a < b) min = Math.min(min, a + (b - a));
        }
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
}
