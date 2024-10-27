import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String record = st.nextToken();

            if (record.equals("enter")) {
                set.add(name);
            } else if (record.equals("leave")) {
                set.remove(name);
            }
        }

        List<String> list = new ArrayList<>();

        for (String s : set) {
            list.add(s);
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
