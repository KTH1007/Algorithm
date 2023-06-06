import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static boolean flag = false;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        for(int i=0; i<n; i++){
            if(flag) break;
            if(arr[0][i] == 0){
                visited = new boolean[m][n];
                visited[0][i] = true;
                DFS(0,i);
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
    static void DFS(int x, int y){
        if(x == m-1){
            flag = true;
            return;
        }
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny] == 0 && !visited[nx][ny]){
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }
}
