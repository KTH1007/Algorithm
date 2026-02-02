import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] map;
    static List<int[]> zeroPosition = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = s.charAt(j) - '0';
                if (map[i][j] == 0) {
                    zeroPosition.add(new int[]{i, j});
                }
            }
        }

        dfs(0);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean dfs(int depth) {
        if (depth == zeroPosition.size()) {
            return true;
        }

        int[] current = zeroPosition.get(depth);
        int i = current[0];
        int j = current[1];

        for (int num = 1; num < 10; num++) {
            if (!rowContainCheck(num, j) && !colContainCheck(num, i) && !boxCheck(num, i, j)) {
                map[i][j] = num;
                if (dfs(depth + 1)) {
                    return true;
                }
                map[i][j] = 0;
            }
        }

        return false;
    }

    private static boolean rowContainCheck(int num, int col) {
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == num) {
                return true;
            }
        }

        return false;
    }

    private static boolean colContainCheck(int num, int row) {
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == num) {
                return true;
            }
        }

        return false;
    }

    private static boolean boxCheck(int num, int row, int col) {
        row /= 3;
        col /= 3;

        for (int i = row * 3; i < row * 3 + 3; i++) {
            for (int j = col * 3; j < col * 3 + 3; j++) {
                if (map[i][j] == num) {
                    return true;
                }
            }
        }

        return false;
    }
}
