import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[] visited;
    static int n;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        map = new int[n][n];
        min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){
            visited[i] = true;
            DFS(i, i, 0, 0);
        }
        System.out.println(min);
    }

    static void DFS(int start, int current, int depth, int sum){
        if(depth == n-1){
            if(map[current][start] != 0){
                sum += map[current][start];
                min = Math.min(min, sum);
            }
            return;
        }
        for(int i=0; i<n; i++){
            if(!visited[i] && map[current][i] != 0){
                visited[i] = true;
                DFS(start, i, depth+1, sum + map[current][i]);
                visited[i] = false;
            }
        }
    }
}
