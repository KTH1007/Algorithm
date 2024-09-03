import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int j = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                list.add(Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list, Collections.reverseOrder());

            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (j <= 0) break;
                j -= list.get(i);
                count++;
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }

}
