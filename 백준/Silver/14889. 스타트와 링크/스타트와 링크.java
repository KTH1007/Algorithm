import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int ability = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(ability);

    }

    private static void dfs(int depth, int at) {
        if (depth == n / 2) {
            int start = 0;
            int link = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (visited[i] && visited[j]) start += arr[i][j] + arr[j][i];
                    else if (!visited[i] && !visited[j]) link += arr[i][j] + arr[j][i];
                }
            }
            if (Math.abs(start - link) < ability) {
                ability = Math.abs(start - link);
            }
            return;
        }

        for (int i = at; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }
}
