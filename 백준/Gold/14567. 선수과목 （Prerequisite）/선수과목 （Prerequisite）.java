import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            arr[b]++;
        }
        topologicalSort();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) sb.append(arr[i]).append(" ");

        System.out.println(sb);

    }

    static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                queue.add(i);
                arr[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < list.get(current).size(); i++) {
                int next = list.get(current).get(i);
                arr[next]--;
                if (arr[next] == 0) {
                    queue.add(next);
                    arr[next] = arr[current] + 1;
                }
            }
        }
    }
}
