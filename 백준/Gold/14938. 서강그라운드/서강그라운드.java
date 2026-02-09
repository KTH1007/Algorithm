import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, m, r;
    static int[] t;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);
        r = Integer.parseInt(tokens[2]);


        tokens = br.readLine().split(" ");
        t = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            t[i] = Integer.parseInt(tokens[i - 1]);
        }

        arr = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(arr[i], 100_000_000);
            arr[i][i] = 0;
        }


        for (int i = 0; i < r; i++) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);

            arr[a][b] = c;
            arr[b][a] = c;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int maxItems = 0;
        for (int i = 1; i <= n; i++) {
            int items = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] <= m) {
                    items += t[j];
                }
            }

            maxItems = Math.max(maxItems, items);
        }

        System.out.println(maxItems);
    }
}
