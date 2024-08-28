import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int count = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            String[] string = new String[n];
            for (int i = 0; i < n; i++) {
                string[i] = br.readLine();
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < 2 * n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int key = Integer.parseInt(st.nextToken());
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            for (int i = 0; i < n; i++) {
                if (map.get(i + 1) != 2) {
                    sb.append(count++).append(" ").append(string[i]).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

}
