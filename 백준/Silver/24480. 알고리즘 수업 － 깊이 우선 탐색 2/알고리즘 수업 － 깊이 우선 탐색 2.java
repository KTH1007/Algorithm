import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int[] visited;
    static int count = 1;
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
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
        visited = new int[n+1];
        for(int i=1; i<=n; i++){
            Collections.sort(list.get(i), Collections.reverseOrder());
        }
        DFS(r);
        for(int i=1; i<=n; i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
    static public void DFS(int r){
        if(visited[r] != 0)
            return;
        visited[r] = count++;
        for(int i=0; i<list.get(r).size(); i++){
            if(visited[list.get(r).get(i)] == 0){
                DFS(list.get(r).get(i));
            }
        }
    }
}
