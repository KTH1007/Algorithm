import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(divideQuarter(n, 0, 0));
    }

    private static int divideQuarter(int n, int x, int y) {
        if (n == 1) {
            return map[x][y];
        }

        int[] dividedMap = new int[] {
                divideQuarter(n / 2, x, y),
                divideQuarter(n / 2, x + n / 2, y),
                divideQuarter(n / 2, x, y + n / 2),
                divideQuarter(n / 2, x + n / 2, y + n / 2)
        };

        Arrays.sort(dividedMap);
        return dividedMap[1];
    }
}
