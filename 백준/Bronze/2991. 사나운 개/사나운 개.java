import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(st.nextToken());
            int count = 0;

            int x = n % (a + b);
            int y = n % (c + d);

            if (x > 0 && x <= a) count++;
            if (y > 0 && y <= c) count++;

            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }
}
