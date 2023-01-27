import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static StringBuilder sb;
    static long[] visited;
    static long[] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i=0; i<=n; i++){
            Collections.sort(list.get(i));
        }
        visited = new long[n+1];
        depth = new long[n+1];
        BFS(r);
        long sum = 0;
        for(int i=1; i<=n; i++){
            sum += visited[i] * depth[i];
        }
        System.out.println(sum);
    }
    public static void BFS(int r){
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        queue.add(r);
        visited[r] = count++;
        depth[r] = 0;
        while(!queue.isEmpty()){
            int c = queue.poll();
            for(int i=0; i<list.get(c).size(); i++){
                int next = list.get(c).get(i);
                if(visited[next] != 0)
                    continue;
                queue.add(next);
                visited[next] = count++;
                depth[next] = depth[c] + 1;
            }
        }
    }
}
