import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int size;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            if(size == 0)
                break;
            arr = new int[size];
            visited = new boolean[size];
            for(int i=0; i<size; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            DFS(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void DFS(int depth, int start){
        if(depth == 6){
            for(int i=0; i<size; i++){
                if(visited[i])
                    sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<size; i++){
            visited[i] = true;
            DFS(depth+1, i+1);
            visited[i] = false;
        }
    }
}
