import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] cow = new int[n][2];
        List<int[]> list = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cow[i][0] = Integer.parseInt(st.nextToken());
            cow[i][1] = Integer.parseInt(st.nextToken());
            list.add(cow[i]);
        }

        list.sort((int[] o1, int[] o2) -> {
            if ((o1[0] - o2[0]) == 0) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int current = 0;

        for (int[] time : list) {
            if (current < time[0]) {
                current = time[0] + time[1];
            } else {
                current += time[1];
            }
        }

        System.out.println(current);
    }
}
