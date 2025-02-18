import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        List<Integer> sortList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            sortList.add(num);
        }

        sortList.sort(null);

        int idx = 0;
        for (int i = 0; i < sortList.size(); i++) {
            if (!map.containsKey(sortList.get(i))) {
                map.put(sortList.get(i), idx++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(list.get(i))).append(" ");
        }

        System.out.println(sb);
    }
}
