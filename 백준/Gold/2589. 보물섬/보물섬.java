import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static char[][] arr;
    static int[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int distance = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new int[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<n; i++)
            Arrays.fill(visited[i],-1);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 'L')
                {
                    BFS(i,j);
                }
            }
        }
        System.out.println(distance);
    }
    static void BFS(int a, int b){
        for(int i=0; i<n; i++)
            Arrays.fill(visited[i],-1);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a,b});
        visited[a][b] = 0;
        int count = 0;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0; i<4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if(nx >=0 && nx<n && ny>=0 && ny<m && visited[nx][ny] == -1 && arr[nx][ny] == 'L'){
                    visited[nx][ny] = visited[current[0]][current[1]] + 1;
                    queue.add(new int[]{nx,ny});
                    distance = Math.max(distance, visited[nx][ny]);
                }
            }
        }
    }

}