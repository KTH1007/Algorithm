import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];
        char[][] player = new char[n][n];
        char[][] result = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], '.');
        }

        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};

        init(n, br, map);
        init(n, br, player);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mineCount(player, i, j, dx, dy, n, map, result);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (flag && map[i][j] == '*') {
                    sb.append('*');
                } else {
                    sb.append(result[i][j]);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void mineCount(char[][] player, int i, int j, int[] dx, int[] dy, int n, char[][] map, char[][] result) {
        if (player[i][j] == 'x') {
            if (map[i][j] == '*') {
                flag = true;
            }
            int count = 0;
            for (int k = 0; k < 8; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == '*') count++;

            }
            result[i][j] = Integer.toString(count).charAt(0);
        }
    }

    private static void init(int n, BufferedReader br, char[][] map) throws IOException {
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
            }
        }
    }
}
