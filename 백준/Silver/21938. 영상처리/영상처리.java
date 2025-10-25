import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] rgb;
    static int[][] map;
    static int count = 0;
    static int n, m, t;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);

        rgb = new int[n][m * 3];
        visited = new boolean[n][m];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < m * 3; j++) {
                rgb[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m * 3; j += 3) {
                int sum = rgb[i][j] + rgb[i][j + 1] + rgb[i][j + 2];
                if ((sum / 3) >= t) {
                    map[i][j / 3] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
    }

    private static void bfs(int i, int j) {
        if (visited[i][j]) return;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
