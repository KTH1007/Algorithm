import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r, c, k;
    static char[][] arr;
    static boolean[][] visited;
    static int count = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        visited[r - 1][0] = true;
        dfs(1, r - 1, 0);
        System.out.println(count);
    }

    static void dfs(int depth, int x, int y) {
        if (x == 0 && y == c - 1) {
            if (depth == k) count++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && arr[nx][ny] != 'T') {
                visited[nx][ny] = true;
                dfs(depth + 1, nx, ny);
                visited[nx][ny] = false;
            }
        }
    }


}