import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        char[][] newMap = new char[r][c];

        bfs(r, c, map, newMap);


        StringBuilder sb = new StringBuilder();
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;

        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {

            int xIdx = -1;
            int yIdx = -1;

            for (int j = 0; j < c; j++) {
                if (newMap[i][j] == 'X') {
                    xIdx = i;
                    minX = Math.min(minX, xIdx);
                    maxX = Math.max(maxX, xIdx);

                    yIdx = j;
                    minY = Math.min(minY, yIdx);
                    maxY = Math.max(maxY, yIdx);
                }
            }
        }

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j<= maxY; j++) {
                sb.append(newMap[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int r, int c, char[][] map, char[][] newMap) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '.') newMap[i][j] = '.';
                else {
                    int count = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || nx >= r || ny < 0 || ny >= c) count++;
                        if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                            if (map[nx][ny] == '.') count++;
                        }
                    }

                    if (count >= 3) newMap[i][j] = '.';
                    else newMap[i][j] = 'X';
                }

            }
        }
    }

}
