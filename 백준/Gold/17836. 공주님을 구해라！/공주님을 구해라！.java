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
        visited = new boolean[n][m][2];  //검을 가졌을 때 왔던 길을 돌아가는 방법이 빠를 수 있음

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
        queue.add(new int[]{0, 0, 0, 0});  //x y time gram
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int time = current[2];
            int gram = current[3];
            if (x == n - 1 && y == m - 1) {
                min = Math.min(min, time);
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && gram == 0 && !visited[nx][ny][0] && arr[nx][ny] != 1) {
                    visited[nx][ny][0] = true;
                    if (arr[nx][ny] == 2) {
                        visited[nx][ny][1] = true;
                        queue.add(new int[]{nx, ny, time + 1, 1});
                    } else queue.add(new int[]{nx, ny, time + 1, gram});

                } else if (nx >= 0 && nx < n && ny >= 0 && ny < m && gram == 1 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.add(new int[]{nx, ny, time + 1, gram});
                }
            }

        }
    }
}
