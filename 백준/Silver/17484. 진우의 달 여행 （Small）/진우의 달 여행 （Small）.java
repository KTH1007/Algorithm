import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            dfs(0, i, arr[0][i], -1);
        }
        System.out.println(min);

    }


    static void dfs(int depth, int y, int sum, int direction) {
        if (depth == n - 1) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nx = depth + 1;
            int ny = y + dy[i];

            if (nx < n && ny >= 0 && ny < m && direction != i) {
                dfs(depth + 1, ny, sum + arr[nx][ny], i);
            }
        }
    }

}
