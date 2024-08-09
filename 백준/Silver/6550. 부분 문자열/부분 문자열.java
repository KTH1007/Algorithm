import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            String string = br.readLine();
            if (string == null || string.equals("")) break;
            st = new StringTokenizer(string);
            String s = st.nextToken();
            String t = st.nextToken();

            int idx = 0;

            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == s.charAt(idx)) {
                    idx++;
                }
                if (idx == s.length()) break;
            }

            if (s.length() == idx) {
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }

        }

        System.out.println(sb);
        br.close();
    }
}
