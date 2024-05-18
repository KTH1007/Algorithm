import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int x, y;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String s1 = st.nextToken();
        String s2 = st.nextToken();

        getIndex(s1, s2);

        for (int i = 0; i < s2.length(); i++) {
            if (i == y) {
                sb.append(s1).append("\n");
                continue;
            }

            for(int j = 0; j < s1.length(); j++) {
                if(j == x) {
                    sb.append(s2.charAt(i));
                }
                else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void getIndex(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            for (int j = 0; j < s2.length(); j++) {
                if (c == s2.charAt(j)) {
                    x = i;
                    y = j;
                    return;
                }
            }
        }
    }
}
