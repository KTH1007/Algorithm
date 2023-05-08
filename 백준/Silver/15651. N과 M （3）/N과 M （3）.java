import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        DFS(0);
        System.out.println(sb);
    }
    static void DFS(int depth){
        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(arr[i]+ " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++){
            arr[depth] = i+1;
            DFS(depth+1);
        }
    }
}
