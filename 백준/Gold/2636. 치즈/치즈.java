import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

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
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    map[i][j] = - 1;
                }
            }
        }

        int time = 0;
        int previousCheese = getCheeseCount();

        while (true) {
            previousCheese = getCheeseCount();
            time++;
            bfs(0, 0);
            changeNum();

            if (getCheeseCount() == 0) {
                break;
            }
        }

        System.out.println(time);
        System.out.println(previousCheese);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) {
                    continue;
                }

                if (map[nr][nc] == 1) {
                    map[nr][nc] = -2;
                }

                if (map[nr][nc] != -2) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }

    private static int getCheeseCount() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void changeNum() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -2) {
                    map[i][j] = 0;
                }
            }
        }
    }
}
