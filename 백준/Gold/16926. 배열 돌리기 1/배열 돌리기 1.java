import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, r;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (r-- > 0) {
            for (int i = 0; i < Math.min(n, m) / 2; i++) {
                rotation(i);
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void rotation(int num) {
        int temp = map[num][num];

        // 왼쪽
        for (int i = num; i < m - num - 1; i++) {
            map[num][i] = map[num][i + 1];
        }

        // 위
        for (int i = num; i < n - num - 1; i++) {
            map[i][m - num - 1] = map[i + 1][m - num - 1];
        }

        // 오른쪽
        for (int i = m - num - 1; i > num; i--) {
            map[n - num - 1][i] = map[n - num - 1][i - 1];
        }

        // 아래
        for (int i = n - num - 1; i > num; i--) {
            map[i][num] = map[i - 1][num];
        }

        map[num + 1][num] = temp;
    }

}
