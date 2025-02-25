import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int white = 0;
    static int blue = 0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void partition(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (arr[row][col] == 0) white++;
            else blue++;
            return;
        }

        int newSize = size / 2;

        partition(row, col, newSize);  // 2사분면
        partition(row, col + newSize, newSize); // 1사분면
        partition(row + newSize, col, newSize);  // 3 사분면
        partition(row + newSize, col + newSize, newSize);  // 4 사분면
    }

    private static boolean colorCheck(int row, int col, int size) {
        int color = arr[row][col]; // 첫 번째 원소를 기준으로 검사

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }

}
