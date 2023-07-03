import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] arr;
    static int[][] result;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(result[i],-1);
        }
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 0)
                    result[i][j] = 0;
                if(arr[i][j] == 2){
                    result[i][j] = 0;
                    BFS(i,j);  // 도착 위치를 출발 위치로 만들어줌
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0; i<4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx >= 0 && nx < n && ny >=0 && ny<m && arr[nx][ny] != 0 && !visited[nx][ny]){
                    queue.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    result[nx][ny] = result[current[0]][current[1]] + 1;
                }
            }
        }
    }
}

