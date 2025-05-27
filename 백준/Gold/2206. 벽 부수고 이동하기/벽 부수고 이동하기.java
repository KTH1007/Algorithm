import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = bfs(0, 0, 1);
        System.out.println(answer);

    }

    private static int bfs(int rStrat, int cStart, int maxMagic) {
        boolean[][][] visited = new boolean[n][m][maxMagic + 1];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {rStrat, cStart, 1, 0}); // 시작 지점, 거리, 벽 부순 횟수

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];
            int magic = current[3];

            // 벽을 마주쳤을 때 더 이상 벽을 부술 수 없는 경우
            if (map[r][c] == '1') {
                if (magic == maxMagic) continue;
                else magic++;
            }

            // 이미 방문한 경우
            if (visited[r][c][magic]) continue;
            visited[r][c][magic] = true;

            // n, m에 도달한 경우
            if (r == n - 1 && c == m - 1) return dist;
            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    queue.add(new int[] {nx, ny, dist + 1, magic});
                }
            }
        }

        return -1;
    }
}
