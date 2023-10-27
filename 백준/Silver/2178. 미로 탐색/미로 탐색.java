import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] arr;
    static boolean[][] visited;
    static int result = Integer.MAX_VALUE;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] depth;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m];
        depth = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        bfs();
        System.out.println(depth[n - 1][m - 1] + 1); //시작 위치 + 1

    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && arr[nx][ny] == '1') {
                    visited[nx][ny] = true;
                    count++;
                    queue.add(new int[]{nx, ny});
                    depth[nx][ny] = depth[x][y] + 1;
                }
            }
        }
    }


}
