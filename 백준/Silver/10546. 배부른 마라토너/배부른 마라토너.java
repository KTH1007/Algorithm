import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) break;

            if (map.containsKey(s)) {
                if (map.get(s) == 1) {
                    map.remove(s);
                } else {
                    map.put(s, map.get(s) - 1);
                }
            } else {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }
}
