import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
            }
            int max = 0;
            String s = "";
            for (String key : map.keySet()) {
                if (map.get(key) > max) s = key;
            }
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

}
