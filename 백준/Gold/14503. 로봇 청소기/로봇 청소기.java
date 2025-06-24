import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, d;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        simulate(startX, startY, d);
        System.out.println(count);
    }

    private static void simulate(int x, int y, int dir) {
        while (true) {
            if (map[x][y] == '0') {
                map[x][y] = '2';
                count++;
            }

            boolean found = false;
            int originalDir = dir;

            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4;
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == '0') {
                    x = nx;
                    y = ny;
                    found = true;
                    break;
                }
            }

            if (!found) {
                int backDir = (originalDir + 2) % 4;
                int bx = x + dx[backDir];
                int by = y + dy[backDir];

                if (bx >= 0 && bx < n && by >= 0 && by < m && map[bx][by] != '1') {
                    x = bx;
                    y = by;
                    dir = originalDir;
                } else {
                    break;
                }
            }
        }

    }
}
