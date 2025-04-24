import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, d;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 10001; i++) {
            graph.add(new ArrayList<>());
        }

        distance = new int[10001];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, w));
        }

        dijkstra(0);

        System.out.println(distance[d]);
    }

    private static void dijkstra(int start) {
        if (start > d) return;

        if (distance[start + 1] > distance[start] + 1) distance[start + 1] = distance[start] + 1;

        for (int i = 0; i < graph.get(start).size(); i++) {
            if (distance[start] + graph.get(start).get(i).distance < distance[graph.get(start).get(i).node]) {
                distance[graph.get(start).get(i).node] = distance[start] + graph.get(start).get(i).distance;
            }
        }

        dijkstra(start + 1);
    }


    static class Node {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
