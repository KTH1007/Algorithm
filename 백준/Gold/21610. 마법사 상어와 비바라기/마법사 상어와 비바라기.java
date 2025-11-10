import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] diagonalR = {1, 1, -1, -1};
    static int[] diagonalC = {-1, 1, -1, 1};
    static int[][] arr;
    static boolean[][] cloud;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);

        arr = new int[n][n];
        cloud = new boolean[n][n];
        init(br);

        cloud[n - 2][0] = true;
        cloud[n - 2][1] = true;
        cloud[n - 1][0] = true;
        cloud[n - 1][1] = true;

        for (int i = 0; i < m; i++) {
            tokens = br.readLine().split(" ");
            int d = Integer.parseInt(tokens[0]) - 1;
            int s = Integer.parseInt(tokens[1]);
            skill(d, s);
        }

        System.out.println(getTotalCount());
    }

    private static int getTotalCount() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count += arr[i][j];
            }
        }

        return count;
    }

    private static void init(BufferedReader br) throws IOException {
        String[] tokens;
        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(tokens[j]);
            }
        }
    }

    private static void skill(int d, int s) {
        move(d, s);
        rain();
        plusCount();
        newCloud();
    }

    private static void newCloud() {
        boolean[][] previousCloud = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                previousCloud[i][j] = cloud[i][j];
                cloud[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] >= 2 && !previousCloud[i][j]) {
                    cloud[i][j] = true;
                    arr[i][j] -= 2;
                }
            }
        }
    }

    private static void plusCount() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cloud[i][j]) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + diagonalR[k];
                        int nc = j + diagonalC[k];

                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && arr[nr][nc] >= 1) {
                            count++;
                        }
                    }
                    arr[i][j] += count;
                }
            }
        }
    }

    private static void rain() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cloud[i][j]) {
                    arr[i][j]++;
                }
            }
        }
    }

    private static void move(int d, int s) {
        boolean[][] newCloud = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cloud[i][j]) {
                    cloud[i][j] = false;
                    int nr = (i + dr[d] * s) % n;
                    int nc = (j + dc[d] * s) % n;

                    if (nr < 0) nr += n;
                    if (nc < 0) nc += n;
                    newCloud[nr][nc] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cloud[i][j] = newCloud[i][j];
            }
        }
    }
}
