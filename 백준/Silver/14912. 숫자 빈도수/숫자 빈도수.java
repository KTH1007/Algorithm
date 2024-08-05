import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        char d = st.nextToken().charAt(0);

        int count = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            if (s.contains(Character.toString(d))) {
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == d) count++;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}
