import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static char[][] map;
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = dijkstra();
        System.out.println(answer);
    }

    private static int dijkstra() {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[2] - o2[2]));
        pq.add(new int[] {0, 0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int cost = current[2];

            if (visited[x][y]) continue;;
            visited[x][y] = true;

            if (x == n - 1 && y == n - 1) return cost;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] == '0') {
                        pq.add(new int[] {nx, ny, cost + 1});
                    } else {
                        pq.add(new int[] {nx, ny, cost});
                    }
                }
            }
        }

        return  -1;
    }

}
