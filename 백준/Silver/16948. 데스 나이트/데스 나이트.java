import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,r1,r2,c1,c2;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-2,-2,0,0,2,2};
    static int[] dc = {-1,1,-2,2,-1,1};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];
        BFS(r1,c1,r2,c2);
        if(answer == Integer.MAX_VALUE)
            answer = -1;
        System.out.println(answer);
    }
    static void BFS(int r1, int c1, int r2, int c2){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r1,c1,1});
        visited[r1][c1] = true;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0; i<6; i++){
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];
                if(nr >=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]){
                    if(nr == r2 && nc == c2){
                        answer = Math.min(answer,current[2]);
                    }
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr,nc,current[2]+1});
                }
            }
        }
    }
}
