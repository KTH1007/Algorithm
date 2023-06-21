import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static char[][] arr;
    static boolean[][] visited;
    static int sheep, wolf;
    static int totalWolf = 0;
    static int totalSheep = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] != '#' && !visited[i][j]){
                    BFS(i,j);
                    if(wolf >= sheep){
                        totalWolf += wolf;
                    }
                    else totalSheep += sheep;
                }
            }
        }
        System.out.println(totalSheep +" " + totalWolf);
    }
    static void BFS(int x, int y){
        wolf = 0;
        sheep = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        if(arr[x][y] == 'v')
            wolf++;
        else if(arr[x][y] == 'k')
            sheep++;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0; i<4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] != '#' && !visited[nx][ny]){
                    if(arr[nx][ny] == 'v')
                        wolf++;
                    else if(arr[nx][ny] == 'k')
                        sheep++;
                    visited[nx][ny] =true;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
    }
}

