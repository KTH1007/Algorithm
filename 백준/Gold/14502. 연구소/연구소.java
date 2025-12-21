import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int maxSafeArea = 0;
    static List<int[]> viruses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokens[j]);
                if (map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }

        bfs(0, 0);
        System.out.println(maxSafeArea);
    }

    private static void bfs(int count, int startX) {
        if (count == 3) {
            maxSafeArea = Math.max(maxSafeArea, spreadVirus());
            return;
        }

        for (int i = startX; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    bfs(count + 1, i);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int spreadVirus() {
        int[][] tempMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            tempMap[i] = map[i].clone();
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] virus : viruses) {
            queue.add(virus);
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && tempMap[nx][ny] == 0) {
                    tempMap[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int safeArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        return safeArea;
    }

}
