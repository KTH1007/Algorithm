import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        // 북 동 남 서 0 1 2 3 - 오른쪽 + 1 (current + 1 % 4),  왼쪽 - 1  if ( current < 0) + 4;

        int direction = 2; // 처음 남쪽을 바라봄

        char[][] map = new char[101][101];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], '#');
        }
        int x = 50;
        int y = 50;
        map[x][y] = '.';

        int maxX = 50;
        int maxY = 50;
        int minX = 50;
        int minY = 50;


        for (int i = 0; i < s.length(); i++) {
            char move = s.charAt(i);

            if (move == 'R') direction = (direction + 1) % 4;
            else if (move == 'L') {
                direction -= 1;
                if (direction == -1) direction = 3;
            } else { // 전진
                x += dx[direction];
                y += dy[direction];
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                map[x][y] = '.';
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
