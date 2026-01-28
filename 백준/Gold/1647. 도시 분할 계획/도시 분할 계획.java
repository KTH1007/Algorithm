import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] edges;
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);

        edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            tokens = br.readLine().split(" ");

            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);

            edges[i][0] = a;
            edges[i][1] = b;
            edges[i][2] = c;

        }

        Arrays.sort(edges, (o1, o2) -> o1[2] - o2[2]);
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        kruskal();
    }

    private static void kruskal() {
        int totalCost = 0;
        int maxEdge = 0;

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            if (union(a, b)) {
                totalCost += cost;
                maxEdge = cost;
            }
        }

        System.out.println(totalCost - maxEdge);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;

        parent[b] = a;
        return true;
    }
}
