import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Edge{
    private int to;
    private int usado;

    public Edge(int to, int usado) {
        this.to = to;
        this.usado = usado;
    }

    public int getTo() {
        return to;
    }

    public int getUsado() {
        return usado;
    }
}

public class Main {
    static List<Edge>[] edges;

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

            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
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
        visited[start] = true;

        Queue<Edge> queue = new ArrayDeque<>();
        queue.add(new Edge(start, Integer.MAX_VALUE));
        int count = 0;

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int node = edge.getTo();
            int minUsado = edge.getUsado();

            for (Edge e : edges[node]) {
                int nextNode = e.getTo();
                int newMinUsado = Math.min(minUsado, e.getUsado());

                if (visited[nextNode]) continue;

                if (newMinUsado >= k) {
                    count++;
                    visited[nextNode] = true;
                    queue.add(new Edge(nextNode, newMinUsado));
                }
            }
        }

        return count;
    }
}
