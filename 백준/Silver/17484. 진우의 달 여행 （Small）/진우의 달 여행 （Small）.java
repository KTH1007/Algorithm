import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1, 0, 1};
    static int n, m;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

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
            int ans = arr[0][i];
            dfs(0, i, 3, ans);
        }
        System.out.println(min);

    }

    static void dfs(int depth, int y, int dir, int ans) {
        if (depth == n-1) {
            min = Math.min(min, ans);
            return;
        }
        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            if (dir != i && ny >= 0 && ny < m) {
                dfs(depth + 1, ny, i, ans + arr[depth+1][ny]);
            }
        }
    }


}