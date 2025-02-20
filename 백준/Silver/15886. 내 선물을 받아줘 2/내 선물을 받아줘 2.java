import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] visited;
    static int[] arr;
    static int n;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        s = br.readLine();

        arr = new int[n];
        visited = new boolean[n];

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'E' && !visited[i]) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int depth) {
        if (depth == n || visited[depth]) return;
        visited[depth] = true;

        if (s.charAt(depth) == 'E') {
            dfs(depth + 1);
        }
    }
}
