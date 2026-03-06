import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m, k;
    static int[][] arr;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] operations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);
        k = Integer.parseInt(tokens[2]);

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        visited = new boolean[k];
        operations = new int[k][3];

        for (int i = 0; i < k; i++) {
            tokens = br.readLine().split(" ");
            int r = Integer.parseInt(tokens[0]) - 1;
            int c = Integer.parseInt(tokens[1]) - 1;
            int s = Integer.parseInt(tokens[2]);

            operations[i][0] = r;
            operations[i][1] = c;
            operations[i][2] = s;

        }

        dfs(0, arr);
        System.out.println(min);
    }

    private static void dfs(int depth, int[][] arr) {
        if (depth == k) {
            min = Math.min(min, rowMin(arr));
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int r = operations[i][0];
                int c = operations[i][1];
                int s = operations[i][2];

                int[][] copy = copyArr(arr);
                rotation(r, c, s, copy);
                dfs(depth + 1, copy);
                visited[i] = false;
            }
        }
    }

    private static int[][] copyArr(int[][] arr) {
        int[][] newArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newArr[i][j] = arr[i][j];
            }
        }

        return newArr;
    }

    private static void rotation(int r, int c, int s, int[][] arr) {
        while (s > 0) {
            int r1 = r - s, r2 = r + s;
            int c1 = c - s, c2 = c + s;

            int temp = arr[r1][c1];

            for (int i = r1; i < r2; i++) arr[i][c1] = arr[i + 1][c1];

            for (int i = c1; i < c2; i++) arr[r2][i] = arr[r2][i + 1];

            for (int i = r2; i > r1; i--) arr[i][c2] = arr[i - 1][c2];

            for (int i = c2; i > c1; i--) arr[r1][i] = arr[r1][i - 1];

            arr[r1][c1 + 1] = temp;

            s--;
        }
    }

    private static int rowMin(int[][] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += arr[i][j];
            }

            min = Math.min(min, sum);
        }

        return min;
    }
}
