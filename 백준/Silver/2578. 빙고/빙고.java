import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //    static int bingo = 0;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[5][5];

        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int bingo = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int n = Integer.parseInt(st.nextToken());
                int[] temp = findIndex(arr, n);
                arr[temp[0]][temp[1]] = -1;
                count++;

                bingo = bingoCheck(arr);
                if (bingo >= 3) {
                    System.out.println(count);
                    return;
                }

            }
        }
    }

    private static int[] findIndex(int[][] arr, int n) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == n) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    private static int bingoCheck(int[][] arr) {
        int bingo = 0;
        bingo += checkRow(arr);
        bingo += checkCol(arr);
        bingo += checkDiagonal(arr);
        return bingo;
    }

    private static int checkRow(int[][] arr) {
        int bingo = 0;
        for (int i = 0; i < 5; i++) {
            boolean check = true;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] != -1) {
                    check = false;
                    break;
                }
            }
            if (check) {
                bingo++;
            }
        }
        return bingo;
    }

    private static int checkCol(int[][] arr) {
        int bingo = 0;
        for (int i = 0; i < 5; i++) {
            boolean check = true;
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] != -1) {
                    check = false;
                    break;
                }
            }
            if (check) {
                bingo++;
            }
        }
        return bingo;
    }

    private static int checkDiagonal(int[][] arr) {
        int bingo = 0;
        // 왼쪽 위에서 오른쪽 아래로 가는 대각선
        boolean check1 = true;
        for (int i = 0; i < 5; i++) {
            if (arr[i][i] != -1) {
                check1 = false;
                break;
            }
        }
        if (check1) {
            bingo++;
        }

        // 오른쪽 위에서 왼쪽 아래로 가는 대각선
        boolean check2 = true;
        for (int i = 0; i < 5; i++) {
            if (arr[i][4 - i] != -1) {
                check2 = false;
                break;
            }
        }
        if (check2) {
            bingo++;
        }

        return bingo;
    }
}
