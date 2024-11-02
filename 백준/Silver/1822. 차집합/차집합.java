import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int countA = Integer.parseInt(st.nextToken());
        int countB = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countA; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countB; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (set.contains(n)) {
                set.remove(Integer.valueOf(n));
            }
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);


        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int i : list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

}
