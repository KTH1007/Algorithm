import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int max = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;
    static int[][] map;
    static boolean[][] visited;

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

        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(1, map[i][j], i, j);
                visited[i][j] = false;
                checkTShape(i, j);
            }
        }

        System.out.println(max);
    }

    private static void checkTShape(int i, int j) {
        // ㅓ
        if (i < n - 1 && (j > 0 && j < m - 1)) {
            int sum = map[i][j] + map[i + 1][j - 1] + map[i + 1][j] + map[i + 1][j + 1];
            max = Math.max(max, sum);
        }

        // ㅏ
        if (i > 0 && (j > 0 && j < m - 1)) {
            int sum = map[i][j] + map[i - 1][j - 1] + map[i - 1][j] + map[i - 1][j + 1];
            max = Math.max(max, sum);
        }

        // ㅜ
        if ((i > 0 && i < n - 1) && j > 0) {
            int sum = map[i][j] + map[i][j - 1] + map[i - 1][j - 1] + map[i + 1][j - 1];
            max = Math.max(max, sum);
        }

        // ㅗ
        if ((i > 0 && i < n - 1) && j < m - 1) {
            int sum = map[i][j] + map[i][j + 1] + map[i - 1][j + 1] + map[i + 1][j + 1];
            max = Math.max(max, sum);
        }
    }

    private static void dfs(int depth, int sum, int x, int y) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(depth + 1, sum + map[nx][ny], nx, ny);
                visited[nx][ny] = false;
            }
        }
    }
}
