import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] arr;
    static boolean[][] visited;
    static int a,b,x,y, n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0 ){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visited = new boolean[n][n];
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            BFS(a,b);
        }
        System.out.println(sb);
    }
    static void BFS(int a, int b){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a,b,0});
        visited[a][b] = true;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            if(current[0] == x && current[1] == y){
                sb.append(current[2]).append("\n");
                return;
            }
            for(int i=0; i<8; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx >=0 && nx < n && ny >=0 && ny < n && !visited[nx][ny]){
                    queue.add(new int[]{nx,ny,current[2]+1});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}

