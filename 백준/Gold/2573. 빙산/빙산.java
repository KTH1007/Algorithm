import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int time = 0;
    static int n, m;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        while (true) {
            int icebergCount = countIcebergs();

            if (icebergCount == 0) {
                System.out.println(0);
                return;
            }

            if (countIcebergs() >= 2) {
                System.out.println(time);
                return;
            }

            time++;
            decreaseIcebergs();
        }
    }

    // 덩어리 탐색
    private static int countIcebergs() {
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(int i, int j, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    // 인접한 바다 수만큼 빙하 녹이기
    private static void decreaseIcebergs() {
        int[][] melt = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                            count++;
                        }
                    }
                    melt[i][j] = count;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = Math.max(0, map[i][j] - melt[i][j]);
            }
        }
    }
}
