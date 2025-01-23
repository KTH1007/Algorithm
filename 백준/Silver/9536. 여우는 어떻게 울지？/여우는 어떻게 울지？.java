import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (t-- > 0) {
            List<String> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }

            while (true) {
                String s = br.readLine();
                if (s.equals("what does the fox say?")) break;

                st = new StringTokenizer(s);
                st.nextToken();
                st.nextToken();
                String sound = st.nextToken();

                while (list.contains(sound)) {
                    list.remove(sound);
                }
            }

            for (String s : list) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
