import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int arr[];
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        DFS(0);
        System.out.println(sb);

    }
    static void DFS(int depth){
        if(depth == n){
            for(int i=0; i<n; i++){
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
            DFS(depth+1);
            visited[i] = false;
        }
    }
}
