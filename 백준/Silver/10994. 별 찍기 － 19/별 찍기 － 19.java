import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] pan = new char[4 * (n - 1) + 1][4 * (n - 1) + 1];

        for (int i = 0; i < 4 * (n - 1) + 1; i++) {
            Arrays.fill(pan[i], ' ');
        }

        StringBuilder sb = new StringBuilder();
        drawStart(0, pan, n);

        for (int i = 0; i < 4 * (n - 1) + 1; i++) {
            for (int j = 0; j < 4 * (n - 1) + 1; j++) {
                sb.append(pan[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

    private static void drawStart(int start, char[][] pan, int n) {
        if (n <= 0) {
            return;
        }
        for (int i = start; i < start + 4 * (n - 1) + 1; i++) {
            pan[start][i] = '*';  // 상단
            pan[i][start] = '*';  // 좌
            pan[start + 4 * (n - 1)][i] = '*';  // 하단
            pan[i][start + 4 * (n - 1)] = '*'; // 우
        }
        drawStart(start + 2, pan, n - 1);
    }
}
