import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]>[] edges;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        String[] tokens;

        for (int i = 0; i < m; i++) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);

            edges[a].add(new int[]{b, c});
            edges[b].add(new int[]{a, c});
        }

        prim(n);
        System.out.println(min);
    }

    private static void prim(int n) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new int[]{1, 0});
        boolean[] visited = new boolean[n + 1];

        int totalCost = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int cost = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            totalCost += cost;
            count++;

            if (count == n) {
                break;
            }

            for (int i = 0; i < edges[node].size(); i++) {
                int next = edges[node].get(i)[0];
                int nextCost = edges[node].get(i)[1];
                if (!visited[next]) {
                    queue.add(new int[]{next, nextCost});
                }
            }
        }

        min = totalCost;
    }
}
