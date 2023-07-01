import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0,0,-1,1,-1,-1,1,1};  //상, 하, 좌, 우, 왼쪽 위, 왼쪽 아래, 오른쪽 위, 오른쪽 아래
    static int[] dy = {1,-1,0,0,1,-1,1,-1};
    static int n,m;
    static int[][] arr;
    static boolean[][] visited;
    static int count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1 && !visited[i][j])
                    BFS(i,j);
            }
        }
        System.out.println(count);
    }
    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        count++;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0; i<8; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx >=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && arr[nx][ny] == 1){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
    }
}

