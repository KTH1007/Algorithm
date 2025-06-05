import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]>[] edges;
    static int n, e, v1, v2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[a].add(new int[] {b, cost});
            edges[b].add(new int[] {a, cost});
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        // 3개 다 -1이면 안 됨
        int A = dijkstra(1, v1);
        int B = dijkstra(v1, v2);
        int C = dijkstra(v2, n);

        int D = dijkstra(1, v2);
        int E = dijkstra(v2, v1);
        int F = dijkstra(v1, n);



        int min = Integer.MAX_VALUE;
        int answer1;
        int answer2;

        if (A != -1 && B != -1 && C != -1) {
            answer1 = A + B + C;
        } else {
            answer1 = Integer.MAX_VALUE;
        }

        if (D != -1 && E != -1 && F != -1) {
            answer2 = D + E + F;
        } else {
            answer2 = Integer.MAX_VALUE;
        }

        min = Math.min(answer1, answer2);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static int dijkstra(int start, int end) {
        Queue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        pq.add(new int[] {start, 0});
        boolean[] visited = new boolean[n + 1];
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];

            if (visited[node]) continue;
            visited[node] = true;

            if (node == end) return dist;

            for (int[] e : edges[node]) {
                int next = e[0];
                int cost = e[1];

                pq.add(new int[] {next, dist + cost});
            }
        }
        return -1;
    }
}
