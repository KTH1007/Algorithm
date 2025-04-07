import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int) (s.charAt(j) - '0');
            }
        }

        quadTree(0, 0, n);
        System.out.println(sb);
    }

    private static void quadTree(int row, int col, int size) {
        boolean check = check(row, col, size);
        if (check) {
            sb.append(arr[row][col]);
            return;
        }

        int newSize = size / 2;
        sb.append("(");
        quadTree(row, col, size / 2);
        quadTree(row, col + newSize, newSize);
        quadTree(row + newSize, col, newSize);
        quadTree(row + newSize, col + newSize, newSize);

        sb.append(")");
    }

    private static boolean check(int row, int col, int size) {
        int start = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != start) return false;
            }
        }

        return true;
    }
}
