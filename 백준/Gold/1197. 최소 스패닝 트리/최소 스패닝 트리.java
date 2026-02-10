import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int v, e;
    static List<int[]>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        v = Integer.parseInt(tokens[0]);
        e = Integer.parseInt(tokens[1]);

        edges = new List[v + 1];

        for (int i = 0; i <= v; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);

            edges[a].add(new int[]{b, c});
            edges[b].add(new int[]{a, c});
        }

        System.out.println(prim());
    }

    private static int prim() {
        boolean[] visited = new boolean[v + 1];
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{1, 0});
        int totalCost = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int cost = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            totalCost += cost;

            for (int[] next : edges[node]) {
                int nextNode = next[0];
                int nextCost = next[1];

                if (!visited[nextNode]) {
                    pq.offer(new int[]{nextNode, nextCost});
                }
            }
        }

        return totalCost;
    }
}
