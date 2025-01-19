import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                if (set.contains(s)) {
                    set.remove(s);
                }
            }
            sb.append(set.size()).append("\n");
        }

        System.out.println(sb);
    }
}
