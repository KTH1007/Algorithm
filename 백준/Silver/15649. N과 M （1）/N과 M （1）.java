import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n];
        DFS(n,m,0);
        System.out.println(sb);
    }
    static void DFS(int n, int m, int depth){
        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++){
            if(visited[i])
                continue;
            arr[depth] = i+1;
            visited[i] = true;
            DFS(n,m,depth+1);
            visited[i] = false;
        }
    }
}