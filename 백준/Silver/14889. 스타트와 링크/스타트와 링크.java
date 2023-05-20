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
        DFS(0, 0);
        System.out.println(min);
    }

    static void DFS(int depth, int idx){
        if(depth == n/2){
            diff();
            return;
        }
        for(int i=idx; i<n; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            DFS(depth+1, i+1);
            visited[i] = false;
        }
    }

    static void diff(){
        int start = 0;
        int link = 0;
        for(int i=0; i<n-1; i++){
            for(int j= i+1; j<n; j++){
                if(visited[i] && visited[j]){
                    start += map[i][j] + map[j][i];
                }
                if(!visited[i] && !visited[j]){
                    link += map[i][j] + map[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(start - link));
    }
}