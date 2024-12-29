import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());
        if (k > r * c) {
            System.out.println(0);
            return;
        }
        if (k == 1) {
            System.out.println(1 + " " + 1);
            return;
        }

        int[][] arr = new int[r][c];

        int value = 2;
        arr[0][0] = 1;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 0;
        int y = 0;
        int dir = 0;
        while (value <= r * c) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= c || ny >= r || arr[ny][nx] != 0) {
                dir = (dir + 1) % 4;
                continue;
            }
            x = nx;
            y = ny;
            arr[y][x] = value++;

            if (arr[y][x] == k) {
                break;
            }
        }
        System.out.println((x + 1) + " " + (y + 1));

    }

}
