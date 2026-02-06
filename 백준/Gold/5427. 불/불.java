import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int h, w;
    static char[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<int[]> fire = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        String[] tokens;
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            tokens = br.readLine().split(" ");
            w = Integer.parseInt(tokens[0]);
            h = Integer.parseInt(tokens[1]);

            map = new char[h][w];
            fire = new ArrayList<>();
            int startX = 0;
            int startY = 0;

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);

                    if (map[i][j] == '@') {
                        startX = i;
                        startY = j;
                    } else if (map[i][j] == '*') {
                        fire.add(new int[]{i, j});
                    }
                }
            }

            int count = bfs(startX, startY);
            if (count != -1) {
                sb.append(count).append("\n");
            } else {
                sb.append("IMPOSSIBLE").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int bfs(int startX, int startY) {
        if (startX == 0 || startX == h - 1 || startY == 0 || startY == w - 1) {
            return 1;
        }

        int[][] fireTime = spreadFire();
        return escapePerson(startX, startY, fireTime);
    }

    private static int escapePerson(int startX, int startY, int[][] fireTime) {
        boolean[][] visited = new boolean[h][w];
        visited[startX][startY] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dr[i];
                int ny = current[1] + dc[i];
                int count = current[2] + 1;

                if (nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny] || map[nx][ny] == '*' || map[nx][ny] == '#'
                || fireTime[nx][ny] <= count) {
                    continue;
                }

                if (nx == 0 || nx == h - 1 || ny == 0 || ny == w - 1) {
                    return count + 1;
                } else {
                    queue.add(new int[]{nx, ny, count});
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }

    private static int[][] spreadFire() {
        int[][] fireTime = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(fireTime[i], 1000000);
        }

        boolean[][] visited = new boolean[h][w];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] f : fire) {
            queue.add(new int[]{f[0], f[1], 0});
            fireTime[f[0]][f[1]] = 0;
            visited[f[0]][f[1]] = true;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dr[i];
                int ny = current[1] + dc[i];
                int currentTime = current[2];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == '*' || map[nx][ny] == '#' || visited[nx][ny]) {
                    continue;
                }

                queue.add(new int[]{nx, ny, currentTime + 1});
                fireTime[nx][ny] = currentTime + 1;
                visited[nx][ny] = true;
            }
        }

        return fireTime;
    }
}
