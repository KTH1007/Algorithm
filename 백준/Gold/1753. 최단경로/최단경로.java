import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]>[] edges;
    static int v, e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        edges = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            edges[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[a].add(new int[] {b, cost});
        }

        int[] distance = dijkstra(start);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= v; i++) {
            if (distance[i] == -1) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int[] dijkstra(int start) {
        boolean[] visited = new boolean[v + 1];
        int[] distance = new int[v + 1];
        Arrays.fill(distance, -1);
        Queue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        pq.add(new int[] {start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];

            if (visited[node]) continue;
            visited[node] = true;
            distance[node] = dist;

            for (int[] e : edges[node]) {
                int next = e[0];
                int cost = e[1];
                pq.add(new int[] {next, dist + cost});
            }
        }

        return distance;
    }

}
