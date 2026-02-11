import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Color {
    private int r;
    private int c;

    public Color(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}

public class Main {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int r = 12;
    static int c = 6;
    static char[][] map;
    static List<Color> red = new ArrayList<>();
    static List<Color> green = new ArrayList<>();
    static List<Color> blue = new ArrayList<>();
    static List<Color> purple = new ArrayList<>();
    static List<Color> yellow = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                char c = s.charAt(j);
                map[i][j] = c;

                if (c == 'R') {
                    red.add(new Color(i ,j));
                } else if (c == 'G') {
                    green.add(new Color(i, j));
                } else if (c == 'B') {
                    blue.add(new Color(i, j));
                } else if (c == 'p') {
                    blue.add(new Color(i, j));
                } else {
                    yellow.add(new Color(i, j));
                }
            }
        }

        int count = 0;

        while (popPuyos()) {
            move();
            count++;
        }

        System.out.println(count);
    }

    private static boolean popPuyos() {
        boolean[][] visited = new boolean[r][c];
        boolean anyPopped = false;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '.' || visited[i][j]) {
                    continue;
                }

                List<int[]> connected = bfs(i, j, visited);

                if (connected.size() >= 4) {
                    for (int[] pos : connected) {
                        map[pos[0]][pos[1]] = '.';
                    }
                    anyPopped = true;

                }
            }
        }

        return anyPopped;
    }

    // 연쇄
    private static List<int[]> bfs(int startR, int startC, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> connected = new ArrayList<>();
        char color = map[startR][startC];

        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            connected.add(new int[]{x, y});

            for (int i = 0; i < 4; i++) {
                int nx = x + dr[i];
                int ny = y + dc[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny] || map[nx][ny] != color) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        return connected;
    }

    // 내리기
    private static void move() {
        for (int j = 0; j < c; j++) {
            int bottom = r - 1;

            for (int i = r - 1; i >= 0; i--) {
                if(map[i][j] == '.') {
                    continue;
                }
                
                if (i != bottom) {
                    map[bottom][j] = map[i][j];
                    map[i][j] = '.';
                }
                
                bottom--;
            }
        }
    }
}
