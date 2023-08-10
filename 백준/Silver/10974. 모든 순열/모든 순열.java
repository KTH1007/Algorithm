import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static boolean[] visited;
    static int[] arr;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n];
        arr = new int[n];
        DFS(0);
        System.out.println(sb);
    }

    static void DFS(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[depth] = i + 1;
            DFS(depth + 1);
            visited[i] = false;
        }

    }

}
