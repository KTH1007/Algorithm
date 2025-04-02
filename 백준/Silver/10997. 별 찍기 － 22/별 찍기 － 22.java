import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] arr;
    static int n;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println("*");
            return;
        }
        arr = new char[4 * n - 1][4 * (n - 1) + 1];

        for (int i = 0; i < 4 * n - 1; i++) {
            Arrays.fill(arr[i], ' ');
        }

        print(2 * n, (4 * (n - 1) + 1) / 2, 2);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4 * n - 1; i++) {
            if (i == 1) {
                sb.append('*').append("\n");
                continue;
            }
            for (int j = 0; j < 4 * (n - 1) + 1; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    static void print(int x, int y, int count) {
        arr[x][y] = '*';
        for (int i = 0; i < count; i++) {
            arr[--x][y] = '*';
        }

        if (x == 0) count = 4 * (n - 1);
        for (int i = 0; i < count; i++) {
            arr[x][++y] = '*';
        }
        if (x == 0 && y == 4 * (n - 1)) return;

        count += 2;

        for (int i = 0; i < count; i++) {
            arr[++x][y] = '*';
        }
        for (int i = 0; i < count; i++) {
            arr[x][--y] = '*';
        }

        print(x, y, count + 2);
    }
}
