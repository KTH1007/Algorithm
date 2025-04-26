import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 8방향이 아닌 4방향만 고려 (→, ↘, ↓, ↗)
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};
    static int firstX;
    static int firstY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[20][20];

        StringTokenizer st;

        for (int i = 1; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if (map[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        if (check(i, k, j, map)) continue;  // 이전 방향에 같은 돌이 있으면 건너뜀

                        int count = 1;
                        int nx = i;
                        int ny = j;

                        for (int l = 0; l < 4; l++) {
                            nx += dx[k];
                            ny += dy[k];

                            if (nx >= 1 && nx < 20 && ny >= 1 && ny < 20 && map[nx][ny] == map[i][j]) {
                                count++;
                            } else {
                                break;
                            }
                        }

                        boolean flag = check2(nx, k, ny, map, i, j);

                        if (count == 5 && !flag) {
                            System.out.println(map[i][j]);
                            System.out.println(i + " " + j);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    private static boolean check2(int nx, int k, int ny, int[][] map, int i, int j) {
        nx += dx[k];
        ny += dy[k];

        boolean flag = nx >= 1 && nx < 20 && ny >= 1 && ny < 20 && map[nx][ny] == map[i][j];
        return flag;
    }

    private static boolean check(int i, int k, int j, int[][] map) {
        // 이전 방향에서 같은 색의 돌이 있는지 확인 (육목 체크를 위해)
        int px = i - dx[k];
        int py = j - dy[k];

        if (px >= 1 && px < 20 && py >= 1 && py < 20 && map[px][py] == map[i][j]) {
            return true;
        }
        return false;
    }

}
