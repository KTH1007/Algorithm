import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static List<List<int[]>> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b,c});
            list.get(b).add(new int[]{a,c});
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = BFS(a,b);
            sb.append(temp).append("\n");
        }
        System.out.println(sb);
    }
    static int BFS(int a, int b){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[a] = 0;
        while (!queue.isEmpty()){
            int current = queue.poll();
            for(int i=0; i<list.get(current).size(); i++){
                int[] next = list.get(current).get(i);
                if(distance[next[0]] == -1){
                    distance[next[0]] = distance[current] + next[1];
                    queue.add(next[0]);
                    if(next[0] == b)
                        return distance[b];
                }
            }

        }
        return -1;
    }

}

