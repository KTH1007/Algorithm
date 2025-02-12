import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            Map<Long, Long> map = new HashMap<>();

            for (int i = 0; i < t; i++) {
                long num = Long.parseLong(st.nextToken());
                map.put(num, map.getOrDefault(num, Long.valueOf(0)) + 1);
            }

            boolean flag = false;
            for (Long i : map.keySet()) {
                if (map.get(i) > t / 2) {
                    flag = true;
                    sb.append(i).append("\n");
                    break;
                }
            }

            if (!flag) sb.append("SYJKGW").append("\n");
        }

        System.out.println(sb);
    }

}
