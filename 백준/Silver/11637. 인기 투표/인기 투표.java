import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> list = new ArrayList<>();
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());
                list.add(new int[]{i, num});
                sum += num;
            }

            Collections.sort(list, (int[] o1, int[] o2) -> o2[1] - o1[1]);

            if (list.get(0)[1] == list.get(1)[1]) {
                sb.append("no winner").append("\n");
                continue;
            }
            if (list.get(0)[1] >= sum / 2 + 1) {
                sb.append("majority winner ").append(list.get(0)[0] + 1).append("\n");
            } else sb.append("minority winner ").append(list.get(0)[0] + 1).append("\n");

        }

        System.out.println(sb);

    }

}
