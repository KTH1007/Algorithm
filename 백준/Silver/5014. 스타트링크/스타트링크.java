import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f, s, g, u, d;
    static int result = 0;
    static boolean[] visited = new boolean[1000001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        if (s == g) System.out.println(0);
        else {
            bfs();
            if (result != 0) System.out.println(result);
            else System.out.println("use the stairs");
        }


    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{s, 0});
        visited[s] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int floor = current[0];
            int count = current[1];
            if (floor == g) {
                result = count;
                return;
            }
            if (floor + u <= f && !visited[floor + u]) {
                visited[floor + u] = true;
                queue.add(new int[]{floor + u, count + 1});
            }
            if (floor - d >= 1 && !visited[floor - d]) {
                visited[floor - d] = true;
                queue.add(new int[]{floor - d, count + 1});
            }
        }
    }


}
