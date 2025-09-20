import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n, m;
    static int max = 0;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        check = new boolean[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    private static void dfs(int depth, int start) {
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int temp = 0;
                for (int j = 0; j < m; j++) {
                    if (check[j]) {
                        temp = Math.max(temp, arr[i][j]);
                    }
                }
                sum += temp;
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = start; i < m; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(depth + 1, start + 1);
                check[i] = false;
            }
        }
    }

}
