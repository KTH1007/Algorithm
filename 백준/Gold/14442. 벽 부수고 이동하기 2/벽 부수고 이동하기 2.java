import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = bfs();
        System.out.println(answer);
    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1, 0});
        boolean[][][] visited = new boolean[n][m][k + 1];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            int magic = current[3];

            if (map[x][y] == '1') {
                if (magic == k) continue;
                else magic++;
            }

            if (x == n - 1 && y == m - 1) return dist;

            if (visited[x][y][magic]) continue;
            visited[x][y][magic] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    queue.add(new int[] {nx, ny, dist + 1, magic});
                }
            }
        }
        return -1;
    }
}
