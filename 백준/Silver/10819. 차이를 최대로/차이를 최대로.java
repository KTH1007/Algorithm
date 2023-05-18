import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int size;
    static int n;
    static int max;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        max = Integer.MIN_VALUE;
        arr = new int[n];
        result = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0);
        System.out.println(max);
    }

    static void DFS(int depth){
        if(depth == n){
            int sum = 0;
            for(int i=0; i<n-1; i++){
                sum += Math.abs(result[i] - result[i+1]);
            }
            max = Math.max(max, sum);
            return;
        }
        for(int i=0; i<n; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            result[depth] = arr[i];
            DFS(depth+1);
            visited[i] = false;
        }
    }
}
