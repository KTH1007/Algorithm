import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int n, m;
    static List<Integer>[] bigger;
    static List<Integer>[] smaller;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);

        bigger = new List[n + 1];
        smaller = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            bigger[i] = new ArrayList<>();
            smaller[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);

            smaller[a].add(b);
            bigger[b].add(a);
        }

        System.out.println(studentCheck());
    }

    private static int studentCheck() {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (canKnowRank(i)) {
                count++;
            }
        }

        return count;
    }

    private static boolean canKnowRank(int student) {
        int tallerCount = bfs(student, smaller);
        int shorterCount = bfs(student, bigger);

        if (tallerCount + shorterCount == n - 1) {
            return true;
        }

        return false;
    }

    private static int bfs(int start, List<Integer>[] edges) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < edges[node].size(); i++) {
                int next = edges[node].get(i);
                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                queue.add(next);
                count++;
            }
        }

        return count;
    }
}
