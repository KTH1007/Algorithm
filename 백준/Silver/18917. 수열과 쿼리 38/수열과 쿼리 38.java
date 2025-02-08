import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        long sum = 0;
        long xor = 0;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int n = Integer.parseInt(st.nextToken());
                sum += n;
                xor ^= n;
            }
            else if (a == 2) {
                int n = Integer.parseInt(st.nextToken());
                sum -= n;
                xor ^= n;
            }
            else if (a == 3) {
                sb.append(sum).append("\n");
            } else {
                sb.append(xor).append("\n");
            }

        }

        System.out.println(sb);

    }
}
