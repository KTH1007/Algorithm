import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<int[]>> list = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b, c});
            list.get(b).add(new int[]{a, c});
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            visited = new boolean[n + 1];
            distance = new int[n + 1];
            BFS(a, b);
            sb.append(distance[b]).append("\n");
        }

        System.out.println(sb);


    }

    static void BFS(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;
        distance[a] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == b) return;
            for (int i = 0; i < list.get(current).size(); i++) {
                int[] next = list.get(current).get(i);
                int nextNode = next[0];
                int nextCost = next[1];
                if (visited[nextNode]) continue;
                visited[nextNode] = true;
                distance[nextNode] = distance[current] + nextCost;
                queue.add(nextNode);
            }
        }
    }

}


