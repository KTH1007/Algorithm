import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] paper = new int[101][101];
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            color(paper, x, y);
        }

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                bfs(paper, i, j);
            }
        }

        System.out.println(count);

    }

    private static void color(int[][] paper, int x, int y) {
        for (int i = y; i < y + 10; i++) {
            for (int j = x; j < x + 10; j++) {
                paper[i][j] = 1;
            }
        }
    }

    private static void bfs(int[][] paper, int i, int j) {
        if (paper[i][j] > 0) {
            for (int k = 0; k < 4; k++) {
                int nx = j + dx[k];
                int ny = i + dy[k];
                if (nx >= 0 && nx < 101 && ny >= 0 && ny < 101) {
                    if (paper[ny][nx] == 0) count++;
                }
            }
        }
    }

}
