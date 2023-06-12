import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
        }
        int[] result = new int[n+1];
        for(int i=1; i<=n; i++){
            visited = new boolean[n+1];
            count = 0;
            BFS(i);
            result[i] = count;
            max = Math.max(max, count);
        }
        for(int i=1; i<=n; i++){
            if(result[i] == max)
                sb.append(i + " ");
        }
        System.out.println(sb);
    }
    static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()){
            int current = queue.poll();
            for(int i : list.get(current)){
                if(visited[i])
                    continue;
                visited[i] = true;
                queue.add(i);
                count++;
            }
        }
    }
}
