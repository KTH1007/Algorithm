import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            list.add(a);
            temp.add(a);
        }

        Collections.sort(temp);

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(temp.get(i))) continue;
            map.put(temp.get(i), idx++);
        }

        for (int i : list) sb.append(map.get(i)).append(" ");

        System.out.println(sb);


    }


}


