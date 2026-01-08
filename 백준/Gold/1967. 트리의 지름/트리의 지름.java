import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static List<int[]>[] edges;
    static int max = 0;
    static int n;
    static int temp = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        String[] tokens;
        for (int i = 0; i < n - 1; i++) {
            tokens = br.readLine().split(" ");

            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);

            edges[a].add(new int[]{b, c});
            edges[b].add(new int[]{a, c});
        }

        bfs(1);
        bfs(temp);

        System.out.println(max);
    }

    private static void bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int cost = current[1];

            if (cost > max) {
                max = cost;
                temp = node;
            }

            for (int i = 0; i < edges[node].size(); i++) {
                int[] next = edges[node].get(i);
                int nextNode = next[0];
                int nextCost = next[1];

                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(new int[]{nextNode, cost + nextCost});
                }
            }
        }
    }
}
