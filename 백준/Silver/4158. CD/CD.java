import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            int count = 0;
            for (int i = 0; i < m; i++) {
                if (set.contains(Integer.parseInt(br.readLine()))) count++;
            }
            sb.append(count).append("\n");
        }


        System.out.println(sb);
        br.close();
    }
}
