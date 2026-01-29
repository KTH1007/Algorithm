import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge {
    private int from;
    private int to;
    private int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getCost() {
        return cost;
    }
}
public class Main {
    static List<Edge> edges = new ArrayList<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);

        for (int i = 0; i < m; i++) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);

            edges.add(new Edge(a, b, c));
        }

        long[] dist = bellmanFord();

        StringBuilder sb = new StringBuilder();

        if (dist == null) {
            System.out.println(-1);
            return;
        }

        for (int i = 2; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static long[] bellmanFord() {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.getFrom()] != Integer.MAX_VALUE && dist[edge.getFrom()] + edge.getCost() < dist[edge.getTo()]) {
                    dist[edge.getTo()] = dist[edge.getFrom()] + edge.getCost();
                }
            }
        }

        for (Edge edge : edges) {
            if (dist[edge.getFrom()] != Integer.MAX_VALUE && dist[edge.getFrom()] + edge.getCost() < dist[edge.getTo()]) {
                return null;
            }
        }

        return dist;
    }
}
