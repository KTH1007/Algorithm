import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, t;
    static int[][] arr;
    static boolean[][][] visited;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[2][n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        if (min > t) System.out.println("Fail");
        else System.out.println(min);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int gram = current[2];
            int time = current[3];

            if (x == n - 1 && y == m - 1) min = Math.min(min, time);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (gram == 0) {
                        if (!visited[0][nx][ny] && arr[nx][ny] != 1) {
                            visited[0][nx][ny] = true;
                            if (arr[nx][ny] == 2) queue.add(new int[]{nx, ny, 1, time + 1});
                            else queue.add(new int[]{nx, ny, 0, time + 1});
                        }
                    } else if (gram == 1) {
                        if (!visited[1][nx][ny]) {
                            visited[1][nx][ny] = true;
                            queue.add(new int[]{nx, ny, gram, time + 1});
                        }
                    }
                }
            }
        }
    }
}
