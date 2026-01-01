import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];

        String[] tokens;

        for (int i = 0; i < 9; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(tokens[j]);
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean dfs(int depth) {
        if (depth == count) {
            return true;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (validateNum(k, i, j)) {
                            map[i][j] = k;
                            if (dfs(depth + 1)) {
                                return true;
                            }
                            map[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }

        return false;
    }

    private static boolean validateNum(int num, int i, int j) {
        return validateWidth(num, i) && validateHeight(num, j) && validateBox(num, i, j);
    }

    private static boolean validateWidth(int num, int i) {
        for (int j = 0; j < 9; j++) {
            if (map[i][j] == num) {
                return false;
            }
        }

        return true;
    }

    private static boolean validateHeight(int num, int j) {
        for (int i = 0; i < 9; i++) {
            if (map[i][j] == num) {
                return false;
            }
        }

        return true;
    }

    private static boolean validateBox(int num, int i, int j) {
        int height = i / 3;
        int width = j / 3;

        for (int k = height * 3; k < (height * 3) + 3; k++) {
            for (int l = width * 3; l < (width * 3) + 3; l++) {
                if (map[k][l] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
