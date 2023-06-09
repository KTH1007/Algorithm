import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,k,x;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean flag = false;
    static int[] dist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }
        visited = new boolean[n+1];
        dist = new int[n+1];
        BFS();
        for(int i=1; i<=n; i++){
            if(dist[i] == k){
                System.out.println(i);
                flag = true;
            }
        }
        if(!flag)
            System.out.println(-1);
    }
    static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        while (!queue.isEmpty()){
            int current = queue.poll();
            for(int i=0; i<list.get(current).size(); i++){
                int next = list.get(current).get(i);
                if(visited[next])
                    continue;
                visited[next] = true;
                queue.add(next);
                dist[next] = dist[current] + 1;
            }
        }
    }
}
