import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int n;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int index = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            map = new int[n][n];
            String[] tokens;
            for (int i = 0; i < n; i++) {
                tokens = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            dijkstra();
            sb.append("Problem ").append(index).append(": ").append(min).append("\n");
            index++;
            min = Integer.MAX_VALUE;
        }

        System.out.println(sb);
    }


    private static void dijkstra() {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        queue.add(new int[]{0, 0, map[0][0]});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int cost = current[2];

            if (r == n - 1 && c == n - 1) {
                min = Math.min(min, cost);
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc, cost + map[nr][nc]});
            }
        }
    }
}
