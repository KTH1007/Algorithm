import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int maxX = 0;
            int maxY = 0;
            int minX = 0;
            int minY = 0;
            int curX = 0;
            int curY = 0;
            int dir = 0;

            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == 'F') {
                    curX += dx[dir];
                    curY += dy[dir];
                } else if (c == 'B') {
                    curX -= dx[dir];
                    curY -= dy[dir];
                } else if (c == 'L') {
                    dir++;
                    dir %= 4;
                } else {
                    dir--;
                    if (dir == -1) dir = 3;
                }

                minX = Math.min(minX, curX);
                minY = Math.min(minY, curY);
                maxX = Math.max(maxX, curX);
                maxY = Math.max(maxY, curY);
            }
            sb.append((Math.abs(maxX) + Math.abs(minX)) * (Math.abs(maxY) + Math.abs(minY))).append("\n");
        }

        System.out.println(sb);
    }
}
