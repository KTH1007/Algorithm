import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int startX, startY, endX, endY;
    static List<int[]> store;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            store = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                store.add(new int[] {a, b});
            }

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            boolean result = bfs();
            if (result) {
                sb.append("happy").append("\n");
            } else {
                sb.append("sad").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {startX, startY});
        boolean[] visited = new boolean[store.size()];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            long dist = Math.abs(endX - x) + Math.abs(endY - y);
            if (dist <= 1000) {
                return true;
            }

            for (int i = 0; i < store.size(); i++) {
                if (visited[i]) continue;

                int[] nextStore = store.get(i);
                long storeDist = Math.abs(nextStore[0] - x) + Math.abs(nextStore[1] - y);

                if (storeDist <= 1000) {
                    queue.add(new int[] {nextStore[0], nextStore[1]});
                    visited[i] = true;
                }
            }
        }
        return false;
    }

}
