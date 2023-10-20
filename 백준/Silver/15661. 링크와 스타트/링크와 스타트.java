import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int t = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (t = 1; t < n; t++) {
            dfs(0, 0);
        }

        System.out.println(min);
    }

    static void dfs(int depth, int index) {
        if (depth == t) {
            diff();
            return;
        }
        for (int i = index; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    static void diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) start += arr[i][j] + arr[j][i];
                else if (!visited[i] && !visited[j]) link += arr[i][j] + arr[j][i];
            }
        }
        min = Math.min(min, Math.abs(start - link));
    }


}
