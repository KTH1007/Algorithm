import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            if (result == 0) dfs(i, 0);
        }

        System.out.println(result);
    }

    static void dfs(int v, int depth) {
        if (depth == 4) {
            result = 1;
            return;
        }
        visited[v] = true;
        for (int i = 0; i < list.get(v).size(); i++) {
            int next = list.get(v).get(i);
            if (visited[next]) continue;
            dfs(next, depth + 1);
        }
        visited[v] = false;
    }


}
