import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Teacher {
    private int r;
    private int c;

    public Teacher(int r, int c) {
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
    private static final int COUNT = 3;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][] obstacle;
    static int n;
    static boolean surveillance = false;
    static List<Teacher> teachers = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        obstacle = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = tokens[j].charAt(0);
                if (map[i][j] == 'T') {
                    teachers.add(new Teacher(i, j));
                }
            }
        }

        dfs(0, 0);
        if (surveillance) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void dfs(int depth, int startIndex) {
        if (surveillance) return;

        if (depth == COUNT) {
            if (canAvoid()) {
                surveillance = true;
            }
            return;
        }

        for (int idx = startIndex; idx < n * n ; idx++) {
            int r = idx / n;
            int c = idx % n;
            if (map[r][c] == 'X') {
                obstacle[r][c] = true;
                dfs(depth + 1, idx + 1);
                obstacle[r][c] = false;
            }
        }
    }

    private static boolean canAvoid() {
        for (Teacher teacher : teachers) {
            for (int dir = 0; dir < dr.length; dir++) {
                int nr = teacher.getR();
                int nc = teacher.getC();

                while (true) {
                    nr += dr[dir];
                    nc += dc[dir];

                    if (nr >= n || nr < 0 || nc >= n || nc < 0) {
                        break;
                    }
                    if (obstacle[nr][nc]) {
                        break;
                    }
                    if (map[nr][nc] == 'S') {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
