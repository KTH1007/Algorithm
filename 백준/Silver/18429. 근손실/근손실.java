import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] arr;
    static boolean[] visited;
    static int count;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count = 0;
        DFS(500, 0);
        System.out.println(count);
    }
    static void DFS(int sum, int idx){
        if(idx == n){
            count++;
            return;
        }
        for(int i=0; i<n; i++){
            if(!visited[i] && (sum + arr[i] - k) >= 500){
                visited[i] = true;
                DFS(sum + arr[i] - k , idx+1);
                visited[i] = false;
            }
        }
    }
}
