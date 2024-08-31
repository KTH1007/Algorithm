import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // @는 3을 곱하고, %는 5를 더하며, #는 7을 빼는 연산자
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            double n = Double.parseDouble(st.nextToken());

            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                if (s.equals("@")) {
                    n *= 3;
                } else if (s.equals("%")) {
                    n += 5;
                } else if (s.equals("#")) {
                    n -= 7;
                }
            }
            sb.append(String.format("%.2f", n)).append("\n");
        }

        System.out.println(sb);
    }

}
