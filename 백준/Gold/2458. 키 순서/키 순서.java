import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m;
    static boolean[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);

        dist = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i][i] = true;
        }

        for (int i = 0; i < m; i++) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);

            dist[a][b] = true;
        }

        floyd();
        System.out.println(studentCheck());
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] && dist[k][j]) {
                        dist[i][j] = true;
                    }
                }
            }
        }
    }

    private static int studentCheck() {
        int totalCount = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] || dist[j][i]) {
                    count++;
                }
            }

            if (count == n) {
                totalCount++;
            }
        }

        return totalCount;
    }
}
