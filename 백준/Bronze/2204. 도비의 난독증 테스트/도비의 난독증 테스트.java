import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            List<String> list = new ArrayList<>();
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                list.add(s.toLowerCase());
                map.put(s.toLowerCase(), s);
            }
            Collections.sort(list);
            sb.append(map.get(list.get(0))).append("\n");
        }

        System.out.println(sb);
    }

}
