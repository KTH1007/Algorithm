import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static boolean flag = false;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        if (flag) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    private static void dfs(int x, int y) {
        if (x == n - 1 && y == n - 1) {
            flag = true;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nx = x;
            int ny = y;
            if (i == 0) {
                nx = x + map[x][y];
            } else {
                ny = y + map[x][y];
            }

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}
