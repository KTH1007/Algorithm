import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            map[b][a] = true;
        }

        int result = iceCream(n, map);
        System.out.println(result);
    }

    private static int iceCream(int n, boolean[][] map) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (map[i][j] || map[j][i]) continue;
                for (int k = j + 1; k <= n; k++) {
                    if (map[i][k] || map[j][k]) {
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
