import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for (int i = 0; i < n; i++) {
            if (ans == 0) DFS(i, 1);
        }
        System.out.println(ans);

    }

    static void DFS(int v, int depth) {
        // 4번 호출 되면 5개 노드가 연결 되어 있는 것
        if (depth == 5) {
            ans = 1;
            return;
        }
        visited[v] = true;
        for (int i = 0; i < list.get(v).size(); i++) {
            int next = list.get(v).get(i);
            if (!visited[next]) {
                DFS(next, depth + 1);
            }
        }
        visited[v] = false;
    }

}
