import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int n, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
        DFS(1, 0, 0);
        System.out.println(ans);

    }

    static void DFS(int x, int y, int direction) {
        if (x == n - 1 && y == n - 1) {
            ans++;
            return;
        }
        //direction 0 -> 가로,  1 -> 세로, 2 -> 대각선
        if (direction == 0) {
            if (x + 1 < n && arr[y][x + 1] == 0) {
                DFS(x + 1, y, 0);
            }
        } else if (direction == 1) {
            if (y + 1 < n && arr[y + 1][x] == 0) DFS(x, y + 1, 1);
        } else {
            if (x + 1 < n && arr[y][x + 1] == 0) DFS(x + 1, y, 0);
            if (y + 1 < n && arr[y + 1][x] == 0) DFS(x, y + 1, 1);
        }
        //대각선은 가로, 세로, 대각선일 떄 모두 포함되기 때문에 아래로 빼줌
        if (x + 1 < n && y + 1 < n && arr[y + 1][x] == 0 && arr[y][x + 1] == 0 && arr[y + 1][x + 1] == 0) {
            DFS(x + 1, y + 1, 2);
        }
    }

}