import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int value = 1;
        int limit = 1;
        int x = n / 2;
        int y = n / 2;

        while (true) {
            for (int i = 0; i < limit; i++) {
                map[y--][x] = value++;
            }
            if (value - 1 == n * n) break;

            for (int i = 0; i < limit; i++) {
                map[y][x++] = value++;
            }

            limit++;

            for (int i = 0; i < limit; i++) {
                map[y++][x] = value++;
            }

            for (int i = 0; i < limit; i++) {
                map[y][x--] = value++;
            }

            limit++;
        }

        StringBuilder sb = new StringBuilder();
        int xPosition = 0;
        int yPosition = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == num) {
                    yPosition = i + 1;
                    xPosition = j + 1;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(yPosition).append(" ").append(xPosition);

        System.out.println(sb);
    }

}
