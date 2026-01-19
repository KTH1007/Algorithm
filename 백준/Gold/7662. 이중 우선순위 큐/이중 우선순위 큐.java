import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        String[] tokens;
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int q = Integer.parseInt(br.readLine());

            TreeMap<Long, Integer> map = new TreeMap<>();

            for (int i = 0; i < q; i++) {
                tokens = br.readLine().split(" ");

                String str = tokens[0];
                long num = Integer.parseInt(tokens[1]);

                if ("I".equals(str)) {
                    map.put(num, map.getOrDefault(num, 0) + 1);

                } else {
                    if (map.isEmpty()) {
                        continue;
                    } else {
                        long target = (num == 1) ? map.lastKey() : map.firstKey();

                        int count = map.get(target);
                        if (count == 1) {
                            map.remove(target);
                        } else {
                            map.put(target, map.get(target) - 1);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
