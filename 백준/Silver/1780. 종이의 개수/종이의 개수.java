import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int count1;
    static int count2;
    static int count3;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, n);
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
    }

    private static void partition(int row, int col, int size) {
        if (numCheck(row, col, size)) {
            if (arr[row][col] == -1) count1++;
            else if (arr[row][col] == 0) count2++;
            else count3++;

            return;
        }

        int newSize = size / 3;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + (2 * newSize), newSize);

        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize, col + (2 * newSize), newSize);

        partition(row + (2 * newSize), col, newSize);
        partition(row + (2 * newSize), col + newSize, newSize);
        partition(row + (2 * newSize), col + (2 * newSize), newSize);
    }

    private static boolean numCheck(int row, int col, int size) {
        int num = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != num)
                    return false;
            }
        }

        return true;
    }
}
