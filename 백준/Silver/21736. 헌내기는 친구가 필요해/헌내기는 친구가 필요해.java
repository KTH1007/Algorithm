import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[][] visited;
    static char[][] arr;
    static int count = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        arr = new char[n][m];

        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y);

        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }

    private static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int newX = cx + dx[i];
                int newY = cy + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    if (!visited[newX][newY] && arr[newX][newY] != 'X') {
                        visited[newX][newY] = true;
                        if (arr[newX][newY] == 'P') count++;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
    }


}
