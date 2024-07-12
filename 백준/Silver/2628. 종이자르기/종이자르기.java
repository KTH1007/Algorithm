import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        List<Integer> horizontal = new ArrayList<>();
        List<Integer> vertical = new ArrayList<>();

        // 처음과 마지막 선 추가
        horizontal.add(0);
        horizontal.add(y);
        vertical.add(0);
        vertical.add(x);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (type == 0) {
                horizontal.add(n);
            } else {
                vertical.add(n);
            }
        }

        Collections.sort(horizontal);
        Collections.sort(vertical);

        System.out.println(maxCount(horizontal) * maxCount(vertical));

        br.close();
    }

    private static int maxCount(List<Integer> list) {
        int diff = 0;
        int max = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            diff = list.get(i + 1) - list.get(i);
            max = Math.max(max, diff);
        }
        return max;
    }
}
