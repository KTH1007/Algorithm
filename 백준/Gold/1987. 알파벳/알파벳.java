import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int max = 1;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int r, c;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        r = Integer.parseInt(tokens[0]);
        c = Integer.parseInt(tokens[1]);

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        Set<Character> set = new HashSet<>();
        set.add(map[0][0]);
        dfs(1, set, 0, 0);
        System.out.println(max);
    }

    private static void dfs(int depth, Set<Character> visited, int currentR, int currentC) {
        for (int i = 0; i < 4; i++) {
            int nr = currentR + dr[i];
            int nc = currentC + dc[i];

            if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
                if (!visited.contains(map[nr][nc])) {
                    visited.add(map[nr][nc]);
                    dfs(depth + 1, visited, nr, nc);
                    visited.remove(map[nr][nc]);
                } else {
                    max = Math.max(max, depth);
                }
            }
        }
    }
}
