import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] move = {{1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,0},{-1,-1},{-1,1}};
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
                if(arr[i][j] == 1) continue;
                int temp = BFS(i,j);
                count = Math.max(count, temp);
            }
        }
        System.out.println(count);

    }
    static int BFS(int row, int col){
        visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col,0});
        visited[row][col] = true;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0; i<8; i++){
                int nx = current[0] + move[i][0];
                int ny = current[1] + move[i][1];
                int dist = current[2]+1;
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])
                    continue;
                if(arr[nx][ny] == 1)
                    return dist;
                queue.add(new int[]{nx,ny,dist});
                visited[nx][ny] = true;
            }
        }
        return 0;
    }
}
