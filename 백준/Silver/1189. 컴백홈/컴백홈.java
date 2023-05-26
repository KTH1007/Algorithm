import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[][] visited;
    static char[][] arr;
    static int r;
    static int c;
    static int k;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visited = new int[r][c];
        for(int i=0; i<r; i++){
            String s = br.readLine();
            arr[i] = s.toCharArray();
        }
        visited[r-1][0] = 1;
        DFS(1, r-1, 0);
        System.out.println(count);
    }

    static void DFS(int depth, int R, int C){
        if(R == 0 && C == c-1 ){
            if(k == depth)
                count++;
            return;
        }
        for(int i=0; i<4; i++){
            int nx = R + dx[i];
            int ny = C + dy[i];
            if(nx < 0 || ny < 0 || nx >= r || ny >= c)
                continue;
            if(visited[nx][ny] == 1 || arr[nx][ny] == 'T')
                continue;
            visited[nx][ny] = 1;
            DFS(depth+1, nx, ny);
            visited[nx][ny] = 0;
        }

    }

}
