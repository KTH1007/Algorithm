import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            map.put(number, map.getOrDefault(number, 0) + 1);
            list.add(number);
            sequence.add(number);
        }

        list.sort((o1, o2) -> {
            if (map.get(o1) == map.get(o2)) {
                return sequence.indexOf(o1) - sequence.indexOf(o2);
            }
            return map.get(o2) - map.get(o1);
        });

        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

}
