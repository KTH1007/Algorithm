import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int l, r, c;
    static int[] dx = {0, 0, 0, 0, -1, 1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static char[][][] arr;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (l == 0 && r == 0 && c == 0) break;
            arr = new char[l][r][c];
            visited = new boolean[l][r][c];
            int count;
            int sx=0,sy=0,sz=0;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < c; k++) {
                        arr[i][j][k] = s.charAt(k);
                        if (arr[i][j][k] == 'S') {
                            sx = k;
                            sy = j;
                            sz = i;
                        }
                    }
                }
                br.readLine();
            }
            count = BFS(sx, sy, sz);
            if (count == -1) {
                sb.append("Trapped!").append("\n");
            } else sb.append("Escaped in ").append(count).append(" minute(s).").append("\n");
        }
        System.out.println(sb);
    }

    static int BFS(int x, int y, int z) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, z, 0});
        visited[z][y][x] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int px = current[0];
            int py = current[1];
            int pz = current[2];
            int currentCount = current[3];
            if (arr[pz][py][px] == 'E')
                return currentCount;
            for (int m = 0; m < 6; m++) {
                int nz = pz + dz[m];
                int nx = px + dx[m];
                int ny = py + dy[m];
                if (nx >= 0 && nx <c && ny >=0 &&ny<r && nz>=0 && nz<l && !visited[nz][ny][nx] && (arr[nz][ny][nx] == '.' || arr[nz][ny][nx] == 'E')) {
                    visited[nz][ny][nx] = true;
                    queue.add(new int[]{nx, ny, nz, currentCount + 1});
                }
            }
        }
        return -1;
    }
}


