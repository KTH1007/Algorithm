import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            char[][] arr = new char[h][w];
            boolean[][] visited = new boolean[h][w];
            for(int i=0; i<h; i++){
                String s = br.readLine();
                for(int j=0; j<w; j++){
                    arr[i][j] = s.charAt(j);
                }
            }
            BFS(h,w,arr,visited);

        }
    }
    static void BFS(int h, int w, char[][] arr, boolean[][] visited){
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(arr[i][j] == '#' && !visited[i][j]){
                    result++;
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
                while (!queue.isEmpty()){
                    int[] a = queue.poll();
                    for(int k=0; k<4; k++){
                        int nx = a[0] + dx[k];
                        int ny = a[1] + dy[k];
                        if(nx >= 0 && nx < h && ny >= 0 && ny < w && arr[nx][ny] == '#' && !visited[nx][ny]){
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
