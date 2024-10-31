import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        set.add("ChongChong");
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            if (set.contains(s1) || set.contains(s2)) {
                if (set.contains(s1)) {
                    set.add(s2);
                } else {
                    set.add(s1);
                }
            }
        }

        System.out.println(set.size());
    }
}
