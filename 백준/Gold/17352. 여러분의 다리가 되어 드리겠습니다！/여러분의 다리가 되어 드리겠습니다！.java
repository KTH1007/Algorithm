import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        for(int i=0; i<n-2; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        DFS(1);
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                System.out.println("1 " + i);
                break;
            }
        }
    }
    static void DFS(int v){
        if(visited[v])
            return;
        visited[v] = true;
        for(int i=0; i<list.get(v).size(); i++){
            int next = list.get(v).get(i);
            if(!visited[next])
                DFS(next);
        }
    }


}