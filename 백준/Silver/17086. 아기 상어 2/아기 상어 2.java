import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[][] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        distance = new int[n][m];

        for (int i = 0; i < n; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    visited = new boolean[n][m];
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) if (arr[i][j] == 0) max = Math.max(max, distance[i][j]);
        }

        System.out.println(max);
    }

    static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b, 0});
        visited[a][b] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && arr[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                    distance[nx][ny] = Math.min(distance[nx][ny], dist + 1);
                }
            }
        }
    }

}
