import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int n,m,r;
    static StringBuilder sb = new StringBuilder();
    static int[] depth;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
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
        for(int i=1; i<=n; i++){
            Collections.sort(list.get(i));
        }
        depth = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(depth, -1);
        depth[r] = 0;
        BFS(r);
        for(int i=1; i<=n; i++){
            sb.append(depth[i]).append("\n");
        }
        System.out.println(sb);
    }
    static void BFS(int r){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        visited[r] = true;
        while (!queue.isEmpty()){
            int a = queue.poll();
            for(int i=0; i<list.get(a).size(); i++){
                int next = list.get(a).get(i);
                if(visited[next])
                    continue;
                visited[next] = true;
                queue.add(next);
                depth[next] = depth[a] + 1;
            }
        }
    }


}
