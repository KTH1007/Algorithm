import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int v, e;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        v = Integer.parseInt(tokens[0]);
        e = Integer.parseInt(tokens[1]);

        arr = new int[v + 1][v + 1];
        for (int i = 0; i <= v; i++) {
            Arrays.fill(arr[i], 10000000);
        }

        for (int i = 0; i < e; i++) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);

            arr[a][b] = c;
        }


        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            min = Math.min(min, arr[i][i]);
        }

        if (min >= 10000000) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}
