import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n, h;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, 1, -1};
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[][][] arr;
    static int day;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1){
                        queue.add(new int[]{i,j,k});
                    }
                }
            }
        }
        BFS();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(arr[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    day = Math.max(day, arr[i][j][k]);
                }
            }
        }
        System.out.println(day-1);

    }

    static void BFS() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int z = current[0];
            int y = current[1];
            int x = current[2];
            for (int l = 0; l < 6; l++) {
                int nx = x + dx[l];
                int ny = y + dy[l];
                int nz = z + dz[l];
                if (nz >=0 && nz< h && ny >=0 && ny<n && nx>=0 && nx<m && arr[nz][ny][nx] == 0) {
                    queue.add(new int[]{nz, ny, nx});
                    arr[nz][ny][nx] = arr[z][y][x] + 1;
                }

            }
        }
    }

}


