import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int count = 0;
    static int height = 0;
    static int maxCount = 1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, arr[i][j]);
            }
        }

        while(height -- >= 0){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][j] > height && !visited[i][j]){
                        count++;
                        BFS(i,j);
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
            count = 0;
            visited = new boolean[n][n];
        }
        System.out.println(maxCount);
    }
    static void BFS(int x, int y){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0; i<4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx >= 0 && nx <n && ny >= 0 && ny < n && arr[nx][ny] > height && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }
}

