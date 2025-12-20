import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int count = 0;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];

        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (canPlace(depth, i)) {
                board[depth] = i;
                dfs(depth + 1);
            }
        }
    }

    private static boolean canPlace(int depth, int col) {
        for (int prevR = 0; prevR < depth; prevR++) {
            int prevC = board[prevR];

            if (prevR == depth || prevC == col) {
                return false;
            }

            if (Math.abs(prevR - depth) == Math.abs(prevC - col)) {
                return false;
            }
        }

        return true;
    }
}
