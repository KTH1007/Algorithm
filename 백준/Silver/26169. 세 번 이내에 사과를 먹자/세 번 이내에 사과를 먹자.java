import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[5][5];
        visited = new boolean[5][5];

        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        visited[r][c] = true;
        if (map[r][c] == 1) {
            dfs(0, 1, r, c);
        } else {
            dfs(0, 0, r, c);
        }
        System.out.println(answer);
    }

    private static void dfs(int depth, int count, int r, int c) {
        if (depth == 3) {
            if (count >= 2) answer = 1;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny] && map[nx][ny] != -1) {
                visited[nx][ny] = true;
                if (map[nx][ny] == 1) {
                    dfs(depth + 1, count + 1, nx, ny);
                } else {
                    dfs(depth + 1, count, nx, ny);
                }
                visited[nx][ny] = false;
            }
        }
    }
}
