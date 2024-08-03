import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        int[] country = new int[n + 1];
        int count = 0;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(list, (int[] o1, int[] o2) -> o2[2] - o1[2]);

        for (int i = 0; i < n; i++) {
            if (count > 2) break;
            if (country[list.get(i)[0]] < 2) {
                count++;
                country[list.get(i)[0]]++;
                sb.append(list.get(i)[0]).append(" ").append(list.get(i)[1]).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
