import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int n, l, r;
    static int[][] map;
    static int count = 0;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        l = Integer.parseInt(tokens[1]);
        r = Integer.parseInt(tokens[2]);

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        while (true) {
            visited = new boolean[n][n];
            boolean moved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) {
                break;
            }

            count++;
        }

        System.out.println(count);
    }

    private static boolean bfs(int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        int sum = map[row][col];

        List<int[]> country = new ArrayList<>();
        country.add(new int[]{row, col});

        boolean flag = false;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentR = current[0];
            int currentC = current[1];

            for (int i = 0; i < 4; i++) {
                int nr = currentR + dr[i];
                int nc = currentC + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) {
                    continue;
                }

                if (Math.abs(map[nr][nc] - map[currentR][currentC]) < l || Math.abs(map[nr][nc] - map[currentR][currentC]) > r) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
                country.add(new int[]{nr, nc});
                sum += map[nr][nc];

                if (!flag) {
                    flag = true;
                }
            }

            if (queue.isEmpty()) {
                int population = sum / country.size();
                for (int i = 0; i < country.size(); i++) {
                    int countryR = country.get(i)[0];
                    int countryC = country.get(i)[1];

                    map[countryR][countryC] = population;
                }
            }
        }

        return flag;
    }
}
