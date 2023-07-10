import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Node implements Comparable<Node>{
    int node;
    int cost;

    public Node(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o){
        return cost - o.cost;
    }
}

public class Main {
    static int n,m;
    static List<List<int[]>> list = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(br.readLine());
       distance = new int[n+1];
       visited = new boolean[n+1];
       Arrays.fill(distance, Integer.MAX_VALUE);
       for(int i=0; i<=n; i++){
           list.add(new ArrayList<>());
       }
       for(int i=0; i<m; i++){
           st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           int c = Integer.parseInt(st.nextToken());
           list.get(a).add(new int[]{b,c});
       }
       st = new StringTokenizer(br.readLine());
       int a = Integer.parseInt(st.nextToken());
       int b = Integer.parseInt(st.nextToken());
        dijkstra(a,b);
        System.out.println(distance[b]);
    }
    static void dijkstra(int a, int b){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(a,0));
        distance[a] = 0;
        while (!pq.isEmpty()){
            Node current = pq.poll();
            int node = current.node;
            int cost = current.cost;

            if(visited[node])
                continue;
            visited[node] = true;
            for(int[] next : list.get(node)){
                int nextNode = next[0];
                int nextCost = cost + next[1];

                if(nextCost < distance[nextNode]){
                    distance[nextNode] = nextCost;
                    pq.add(new Node(nextNode, nextCost));
                }
            }
        }
    }

}
