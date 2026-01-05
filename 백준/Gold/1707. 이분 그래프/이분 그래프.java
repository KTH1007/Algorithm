import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
    static List<Integer>[] edges;
    static int v, e;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            // 단방향 그래프로 구현하는데 순회하면 안 됨

            String[] tokens = br.readLine().split(" ");
            v = Integer.parseInt(tokens[0]);
            e = Integer.parseInt(tokens[1]);

            edges = new ArrayList[v + 1];

            for (int i = 1; i <= v; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                tokens = br.readLine().split(" ");
                int a = Integer.parseInt(tokens[0]);
                int b = Integer.parseInt(tokens[1]);

                edges[a].add(b);
                edges[b].add(a);
            }

            color = new int[v + 1];
            Arrays.fill(color, -1);

            boolean flag = false;
            for (int i = 1; i <= v; i++) {
                if (color[i] == -1) {
                    flag = bfs(i);
                    if (!flag) {
                        break;
                    }
                }
            }

            if (flag) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean bfs(int index) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(index);
        color[index] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < edges[current].size(); i++) {
                int next = edges[current].get(i);

                if (color[next] == -1) {
                    color[next] = 1 - color[current];
                    queue.add(next);
                } else if (color[next] == color[current]) {
                    return false;
                }
            }
        }

        return true;
    }
}
