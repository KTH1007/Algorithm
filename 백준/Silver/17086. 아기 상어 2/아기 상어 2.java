import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) bfs(i, j);
            }
        }

        System.out.println(max);
    }

    static void bfs(int a, int b) {
        visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b, 0});
        visited[a][b] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                int dist = current[2] + 1;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    if (arr[nx][ny] == 1) {
                        max = Math.max(max, dist);
                        return;
                    }
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist});

                }
            }
        }
    }


}
