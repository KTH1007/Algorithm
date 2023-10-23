import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, r;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];
        arr = new int[n + 1];
        Arrays.fill(arr, -1);
        arr[r] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        bfs(r);
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        visited[r] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < list.get(current).size(); i++) {
                int next = list.get(current).get(i);
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(next);
                arr[next] = arr[current] + 1;
            }
        }
    }


}
