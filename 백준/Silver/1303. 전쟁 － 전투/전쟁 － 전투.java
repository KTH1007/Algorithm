import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int blueCount = 0;
    static int whiteCount = 0;
    static int blue = 0;
    static int white = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
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
                if(visited[i][j])
                    continue;
                DFS(i,j,arr[i][j]);
                blue += blueCount * blueCount;
                white += whiteCount * whiteCount;
                blueCount = 0;
                whiteCount = 0;
            }
        }
        System.out.println(white +" " + blue);
    }
    static void DFS(int x, int y, char c){
        visited[x][y] = true;
        if(c == 'W')
            whiteCount++;
        else
            blueCount++;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0  && ny < m && !visited[nx][ny] && arr[nx][ny] == c)
                DFS(nx,ny,c);
        }
    }
}
