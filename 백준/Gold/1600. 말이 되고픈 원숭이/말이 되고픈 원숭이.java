import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int k, w, h;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] magicX = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] magicY = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new char[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        int answer = bfs();
        System.out.println(answer);
    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[h][w][k + 1];
        queue.add(new int[] {0, 0, 0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            int magic = current[3];

            if (x == h - 1 && y == w - 1) return dist;

            if (visited[x][y][magic]) continue;
            visited[x][y][magic] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] != '1') {
                    queue.add(new int[] {nx, ny, dist + 1, magic});
                }
            }

            if (magic < k) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + magicX[i];
                    int ny = y + magicY[i];

                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] != '1') {
                        queue.add(new int[] {nx, ny, dist + 1, magic + 1});
                    }
                }
            }


        }

        return -1;
    }

}
