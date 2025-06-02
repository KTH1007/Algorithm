import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = dijkstra();
        System.out.println(answer);
    }

    private static int dijkstra() {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[2] - o2[2]));
        pq.add(new int[] {0, 0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            if (visited[x][y]) continue;
            visited[x][y] = true;

            // 목표 지점 도달
            if (x == n - 1 && y == m - 1) return count;

            // 4방향 탐색 벽인 경우 count 증가
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    if (map[nx][ny] == '1') {
                        pq.add(new int[] {nx, ny, count + 1});
                    } else {
                        pq.add(new int[] {nx, ny, count});
                    }
                }
            }
        }
        return -1;
    }
}
