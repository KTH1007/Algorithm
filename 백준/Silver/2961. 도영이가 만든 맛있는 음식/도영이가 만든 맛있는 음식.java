import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] food;
    static boolean[] visited;
    static int diff;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        food = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            food[i][0] = Integer.parseInt(st.nextToken());
            food[i][1] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[n];
        diff = Integer.MAX_VALUE;
        DFS(0);
        System.out.println(diff);
    }
    static void DFS(int depth){
        if(depth == n){
            int s = 1;
            int b = 0;
            int count = 0;
            for(int i=0; i<visited.length; i++){
                if(visited[i]){
                    count++;
                    s *= food[i][0];
                    b += food[i][1];
                }
            }
            if(count == 0) return;
            if(diff > Math.abs(s - b))
                diff = Math.abs(s - b);
            return;
        }
        visited[depth] = true;
        DFS(depth+1);
        visited[depth] = false;
        DFS(depth+1);
    }
}
