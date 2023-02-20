import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        int[] length = new int[n+1];
        for(int i=0; i<=n; i++){
            length[i] = bfs(i);
        }
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(length[i] < min){
                min = length[i];
                answer = i;
            }
        }
        System.out.println(answer);
    }

    static int bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(visited, false);
        int[] dist = new int[n+1];
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int a = queue.poll();
            for (int i = 0; i < list.get(a).size(); i++) {
                int next = list.get(a).get(i);
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    dist[next] = dist[a] + 1;
                }
            }
        }
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += dist[i];
        }
        return sum;
    }
}