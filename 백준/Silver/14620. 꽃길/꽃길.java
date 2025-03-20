import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        back(0, 0);

        System.out.println(min);
    }

    private static void back(int depth, int sum) {
        if (depth == 3) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!visited[i][j] && !visited[i - 1][j] && !visited[i][j - 1] && !visited[i][j + 1] && !visited[i + 1][j]) {
                    visited[i][j] = visited[i - 1][j] = visited[i][j - 1] = visited[i][j + 1] = visited[i + 1][j] = true;
                    int flowerCost = arr[i][j] + arr[i - 1][j] + arr[i][j - 1] + arr[i][j + 1] + arr[i + 1][j];
                    back(depth + 1, sum + flowerCost);
                    visited[i][j] = visited[i - 1][j] = visited[i][j - 1] = visited[i][j + 1] = visited[i + 1][j] = false;
                }
            }
        }
    }

}
