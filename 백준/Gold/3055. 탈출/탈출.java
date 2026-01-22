import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int r, c;
    static char[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int time = Integer.MAX_VALUE;
    static boolean[][] waterVisited;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        r = Integer.parseInt(tokens[0]);
        c = Integer.parseInt(tokens[1]);

        map = new char[r][c];
        waterVisited = new boolean[r][c];

        int startR = 0;
        int startC = 0;
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    startR = i;
                    startC = j;
                }
                if (map[i][j] == '*') {
                    list.add(new int[]{i, j});
                    waterVisited[i][j] = true;
                }
            }
        }

        bfs(startR, startC);

        if (time == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(time);
        }

    }

    private static void bfs(int startR, int startC) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];
        queue.add(new int[]{startR, startC, 0});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            moveWater();

            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = current[0] + dr[i];
                    int nc = current[1] + dc[i];

                    if (nr < 0 || nr >= r || nc < 0 || nc >= c || visited[nr][nc] || map[nr][nc] == '*' || map[nr][nc] == 'X' || waterVisited[nr][nc]) {
                        continue;
                    }

                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, current[2] + 1});

                    if (map[nr][nc] == 'D') {
                        time = current[2] + 1;
                        return;
                    }
                }
            }
        }
    }

    private static void moveWater() {
        List<int[]> temp = new ArrayList<>();
        for (int[] water : list) {
            int waterR = water[0];
            int waterC = water[1];

            for (int i = 0; i < 4; i++) {
                int nr = waterR + dr[i];
                int nc = waterC + dc[i];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c || waterVisited[nr][nc] || map[nr][nc] == '*' || map[nr][nc] == 'X' || map[nr][nc] == 'S' || map[nr][nc] == 'D') {
                    continue;
                }

                temp.add(new int[]{nr, nc});
                waterVisited[nr][nc] = true;
            }
        }
        list.addAll(temp);
    }
}
