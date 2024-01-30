import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 1);
        System.out.println(count);
    }


    static void dfs(int x, int y, int direction) {
        if (x == n - 1 && y == n - 1) {
            count++;
        }

        if (direction == 1) {  //가로
            if (y + 1 < n && arr[x][y + 1] != 1) {
                dfs(x, y + 1, 1);
            }
        } else if (direction == 2) {  //세로
            if (x + 1 < n && arr[x + 1][y] != 1) {
                dfs(x + 1, y, 2);
            }
        } else if (direction == 3) {  //대각선
            if (y + 1 < n && arr[x][y + 1] != 1) {
                dfs(x, y + 1, 1);
            }
            if (x + 1 < n && arr[x + 1][y] != 1) {
                dfs(x + 1, y, 2);
            }
        }
        if (x + 1 < n && y + 1 < n && arr[x][y + 1] != 1 && arr[x + 1][y] != 1 && arr[x + 1][y + 1] != 1) {
            dfs(x + 1, y + 1, 3);
        }
    }


}
