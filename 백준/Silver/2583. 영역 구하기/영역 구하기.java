import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m,n,k;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int count = 0;
    static int x1,x2,y1,y2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        visited = new boolean[m][n];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            for(int a=y1; a<y2; a++){
                for(int b=x1; b<x2; b++){
                    arr[a][b] = 1;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<m; i++){
            count = 0;
            for(int j=0; j<n; j++){
                if(!visited[i][j] && arr[i][j] == 0){
                    BFS(i,j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) +" ");
        }
    }
    static void BFS(int x, int y){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        count = 1;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0; i<4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx >=0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && arr[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny});
                    count++;
                }
            }
        }
    }
}

