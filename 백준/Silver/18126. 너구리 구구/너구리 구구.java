import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    static class Edge {
        int destination;
        long distance;

        Edge(int destination, long distance) {
            this.destination = destination;
            this.distance = distance;
        }
    }

    static List<Edge>[] edges;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        edges = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        int count = n - 1;
        while (count-- > 0) {
            String str = br.readLine();
            String[] tokens = str.split(" ");

            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            long c = Long.parseLong(tokens[2]);
            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }

        System.out.println(bfs());
    }

    private static long bfs() {
        Queue<Edge> queue = new ArrayDeque<>();
        queue.add(new Edge(1, 0)); // 도착지, 이동 거리
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        long maxDistance = 0;

        while (!queue.isEmpty()) {
            Edge node = queue.poll();
            int destination = node.destination;
            long distance = node.distance;

            maxDistance = Math.max(maxDistance, distance);

            for (Edge edge : edges[destination]) {
                if (visited[edge.destination]) {
                    continue;
                }
                visited[edge.destination] = true;
                queue.add(new Edge(edge.destination, distance + edge.distance));
            }
        }

        return maxDistance;
    }

}
