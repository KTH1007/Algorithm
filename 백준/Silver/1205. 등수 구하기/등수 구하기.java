import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        } else {
            System.out.println(1);
            return;
        }
        list.sort((o1, o2) -> o2 - o1);

        if (list.get(n - 1) >= score && (n == p)) {
            System.out.println(-1);
            return;
        }

        int rank = 1;
        for (int i : list) {
            if (i > score) {
                rank++;
            } else {
                break;
            }
        }

        System.out.println(rank);

    }
}
