import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[1000001];
        bfs();
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        visited[n] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int count = current[1];
            if (value == m) {
                System.out.println(count);
                return;
            }
            if (value * 2 <= m) {
                queue.add(new int[]{value * 2, count + 1});
                visited[value * 2] = true;
            }
            if (!visited[value + 1]) {
                queue.add(new int[]{value + 1, count + 1});
                visited[value + 1] = true;
            }
        }

    }
}