import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static  List<List<Integer>> list = new ArrayList<>();
    static long[] visited;
    static long[] depth;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
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
        visited = new long[n+1];
        depth = new long[n+1];
        for(int i=0; i<=n; i++){
            Collections.sort(list.get(i));
        }
        Arrays.fill(depth, -1);
        depth[r] = 0;
        DFS(r);
        long sum = 0;
        for(int i=1; i<=n; i++){
            sum += visited[i] * depth[i];
        }
        System.out.println(sum);
    }
    public static void DFS(int r){
        if(visited[r] != 0)
            return;
        visited[r] = count++;
        for(int i=0; i<list.get(r).size(); i++){
            if(visited[list.get(r).get(i)] == 0){
                depth[list.get(r).get(i)] = depth[r] + 1;
                DFS(list.get(r).get(i));
            }
        }

    }
}