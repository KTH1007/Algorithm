import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int r, c, t;
    static int[] dx = {1, -1 ,0 ,0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int airPurifierTop, airPurifierBottom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        r = Integer.parseInt(tokens[0]);
        c = Integer.parseInt(tokens[1]);
        t = Integer.parseInt(tokens[2]);

        map = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(tokens[j]);
                if (map[i][j] == -1) {
                    if (airPurifierTop == 0) {
                        airPurifierTop = i;
                    } else {
                        airPurifierBottom = i;
                    }
                }
            }
        }

        while (t-- > 0) {
            spread();
            circulation();
        }

        int total = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    total += map[i][j];
                }
            }
        }

        System.out.println(total);
    }

    private static void spread() {
        int[][] newMap = new int[r][c];

        newMap[airPurifierTop][0] = -1;
        newMap[airPurifierBottom][0] = -1;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    int amount = map[i][j] / 5;
                    int count = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] != -1) {
                            newMap[nx][ny] += amount;
                            count++;
                        }
                    }

                    newMap[i][j] += map[i][j] - (amount * count);
                }
            }
        }

        map = newMap;
    }
    
    private static void circulation() {
        // 위쪽 공기청정기 (반시계 방향)
        // 위 -> 아래 (맨 왼쪽)
        for (int i = airPurifierTop - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }

        // 오른쪽 -> 왼쪽 (맨 위)
        for (int i = 0; i < c - 1; i++) {
            map[0][i] = map[0][i + 1];
        }

        // 아래 -> 위 (맨 오른쪽)
        for (int i = 0; i < airPurifierTop; i++) {
            map[i][c - 1] = map[i + 1][c - 1];
        }

        // 왼쪽 -> 오른쪽
        for (int i = c - 1; i > 1; i--) {
            map[airPurifierTop][i] = map[airPurifierTop][i - 1];
        }

        map[airPurifierTop][1] = 0; // 공기청정기에서 나오는 바람


        // 아래쪽 공기청정기 (시계 방향)
        // 위 -> 아래
        for (int i = airPurifierBottom + 1; i < r - 1; i++) {
            map[i][0] = map[i + 1][0];
        }

        // 왼쪽 -> 오른쪽 (맨 아래)
        for (int j = 0; j < c - 1; j++) {
            map[r - 1][j] = map[r - 1][j + 1];
        }

        // 아래 -> 위 (맨 오른쪽)
        for (int i = r - 1; i > airPurifierBottom; i--) {
            map[i][c - 1] = map[i - 1][c - 1];
        }

        // 오른쪽 -> 왼쪽
        for (int j = c - 1; j > 1; j--) {
            map[airPurifierBottom][j] = map[airPurifierBottom][j - 1];
        }
        map[airPurifierBottom][1] = 0;
    }
}
