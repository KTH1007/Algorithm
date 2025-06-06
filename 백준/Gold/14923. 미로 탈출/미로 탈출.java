import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        st = new StringTokenizer(br.readLine());
        int hx = Integer.parseInt(st.nextToken()) - 1;
        int hy = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken()) - 1;
        int ey = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        int answer = bfs(hx, hy, ex, ey, 1);
        System.out.println(answer);
    }

    private static int bfs(int hx, int hy, int ex, int ey, int magicCount) {
        boolean[][][] visited = new boolean[n][m][magicCount + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {hx, hy, 0, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            int magic = current[3];

            if (map[x][y] == '1') {
                if (magic == magicCount) continue;
                else magic++;
            }

            if (visited[x][y][magic]) continue;
            visited[x][y][magic] = true;

            if (x == ex && y == ey) return dist;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny][magic]) {
                    queue.add(new int[] {nx, ny, dist + 1, magic});
                }
            }
        }
        return -1;
    }

}
