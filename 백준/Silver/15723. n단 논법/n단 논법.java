import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static List<Integer>[] lists;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        lists = new ArrayList[27];
        for (int i = 0; i < 27; i++) {
            lists[i] = new ArrayList<>();
        }

        String[] tokens;

        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" is ");
            int alpha1 = tokens[0].charAt(0) - 'a';
            int alpha2 = tokens[1].charAt(0) - 'a';
            lists[alpha1].add(alpha2);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            tokens = br.readLine().split(" is ");
            int alpha1 = tokens[0].charAt(0) - 'a';
            int alpha2 = tokens[1].charAt(0) - 'a';

            if (bfs(alpha1, alpha2)) {
                sb.append("T").append("\n");
            } else {
                sb.append("F").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean bfs(int a, int b) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[27];
        queue.add(a);
        visited[a] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == b) {
                return true;
            }
            for (int i = 0; i < lists[current].size(); i++) {
                int next = lists[current].get(i);
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }

        return false;
    }
}
