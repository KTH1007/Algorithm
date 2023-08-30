import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] arr2 = new int[n];
        dfs(0, arr2);
        System.out.println(sb);
    }

    static void dfs(int depth, int[] arr2) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr2[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || before == arr[i]) continue;
            visited[i] = true;
            arr2[depth] = arr[i];
            before = arr[i];
            dfs(depth + 1, arr2);
            visited[i] = false;
        }
    }


}