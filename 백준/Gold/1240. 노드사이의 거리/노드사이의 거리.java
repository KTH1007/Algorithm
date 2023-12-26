import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<int[]>> list = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b, c});
            list.get(b).add(new int[]{a, c});
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            visited = new boolean[n + 1];
            bfs(a, b);
        }

        System.out.println(sb);

    }

    static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, 0});
        visited[a] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int distance = current[1];
            for (int i = 0; i < list.get(x).size(); i++) {
                int[] next = list.get(x).get(i);
                int nx = next[0];
                int nextDistacne = next[1];
                if (!visited[nx]) {
                    if (nx == b) {
                        sb.append(distance + nextDistacne).append("\n");
                        return;
                    } else {
                        visited[nx] = true;
                        queue.add(new int[]{nx, distance + nextDistacne});
                    }
                }
            }
        }
    }


}


