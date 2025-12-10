import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static List<int[]>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int q = Integer.parseInt(tokens[1]);

        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);

            edges[a].add(new int[]{b, c});
            edges[b].add(new int[]{a, c});
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            tokens = br.readLine().split(" ");
            int k = Integer.parseInt(tokens[0]);
            int num = Integer.parseInt(tokens[1]);

            sb.append(bfs(k, num, n)).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int k, int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, Integer.MAX_VALUE});
        int count = 0;
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int minUsado = current[1];

            for (int[] edge : edges[node]) {
                int nextNode = edge[0];
                int edgeUsagdo = edge[1];

                if (visited[nextNode]) continue;

                int newMinUsado = Math.min(minUsado, edgeUsagdo);

                if (newMinUsado >= k) {
                    count++;
                    visited[nextNode] = true;
                    queue.add(new int[]{nextNode, newMinUsado});
                }
            }
        }
        return count;
    }
}
