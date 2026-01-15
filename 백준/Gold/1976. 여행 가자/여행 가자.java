import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int n, m;
    static List<Integer>[] edges;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        String[] tokens;
        for (int i = 1; i <= n; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                int connect = Integer.parseInt(tokens[j - 1]);

                if (connect == 1) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        tokens = br.readLine().split(" ");
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        boolean isConnect = true;
        for (int i = 1; i < m; i++) {
            if (arr[i - 1] == arr[i]) {
                continue;
            }
            if (!bfs(arr[i - 1], arr[i])) {
                isConnect = false;
            }
        }

        if (isConnect) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean bfs(int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited = new boolean[n + 1];
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < edges[current].size(); i++) {
                int next = edges[current].get(i);

                if (next == end) {
                    return true;
                }

                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }

        return false;
    }
}
