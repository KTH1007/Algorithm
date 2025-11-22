import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m, r;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);
        r = Integer.parseInt(tokens[2]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        tokens = br.readLine().split(" ");
        for (int i = 0; i < r; i++) {
            int num = Integer.parseInt(tokens[i]);
            if (num == 1) {
                map = func1(map);
            }
            if (num == 2) {
                map = func2(map);
            }
            if (num == 3) {
                map = func3(map);
            }
            if (num == 4) {
                map = func4(map);
            }
            if (num == 5) {
                map = func5(map);
            }
            if (num == 6) {
                map = func6(map);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int[][] func1(int[][] map) {
        int[][] temp = new int[n][m];
        int tempRow = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                temp[tempRow][j] = map[i][j];
            }
            tempRow++;
        }
        return temp;
    }

    private static int[][] func2(int[][] map) {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            int tempCol = 0;
            for (int j = m - 1; j >= 0; j--) {
                temp[i][tempCol++] = map[i][j];
            }
        }
        return temp;
    }

    private static int[][] func3(int[][] map) {
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = map[n - 1 - j][i];
            }
        }

        int tmp = n;
        n = m;
        m = tmp;

        return temp;
    }

    private static int[][] func4(int[][] map) {
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = map[j][m - 1 - i];
            }
        }

        int tmp = n;
        n = m;
        m = tmp;

        return temp;
    }

    private static int[][] func5(int[][] map) {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < n / 2 && j < m / 2) {
                    temp[i][j] = map[i + n / 2][j];
                } else if (i < n / 2 && j >= m / 2) {
                    temp[i][j] = map[i][j - m / 2];
                } else if (i >= n / 2 && j >= m / 2) {
                    temp[i][j] = map[i - n / 2][j];
                } else if (i >= n / 2 && j < m / 2) {
                    temp[i][j] = map[i][j + m / 2];
                }
            }
        }

        return temp;
    }

    private static int[][] func6(int[][] map) {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < n / 2 && j < m / 2) {
                    temp[i][j] = map[i][j + m /2];
                } else if (i < n / 2 && j >= m / 2) {
                    temp[i][j] = map[i + n / 2][j];
                } else if (i >= n / 2 && j >= m / 2) {
                    temp[i][j] = map[i][j - m / 2];
                } else if (i >= n / 2 && j < m / 2) {
                    temp[i][j] = map[i - n / 2][j];
                }
            }
        }

        return temp;
    }
}
