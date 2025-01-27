import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        StringTokenizer st;

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            if (set.contains(s1) || set.contains(s2)) {
                set.add(s1);
                set.add(s2);
            }
        }

        System.out.println(set.size());
    }
}
