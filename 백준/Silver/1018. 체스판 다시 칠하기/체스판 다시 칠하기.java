import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < m - 7; i++) {
            for (int j = 0; j < n - 7; j++) {
                min = Math.min(findMin(j, i, map), min);
            }
        }

        System.out.println(min);
    }

    private static int findMin(int x, int y, char[][] map) {
        int count = 0;
        char c = map[y][x];
        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
                if (map[i][j] != c) {
                    count++;
                }
                if (c == 'B') {
                    c = 'W';
                } else if (c == 'W') {
                    c = 'B';
                }
            }
            if (c == 'W') {
                c = 'B';
            } else {
                c = 'W';
            }
        }
        return Math.min(count, 64 - count);
    }
}
