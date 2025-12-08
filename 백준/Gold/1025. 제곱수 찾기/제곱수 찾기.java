import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int maxSquare = -1;

        for (int startR = 0; startR < n; startR++) {
            for (int startC = 0; startC < m; startC++) {
                for (int rd = -n; rd < n; rd++) {
                    for (int cd = -m; cd < m; cd++) {
                        int square = findMaxSquare(arr, n, m, startR, startC, rd, cd);
                        maxSquare = Math.max(maxSquare, square);
                    }
                }
            }
        }

        System.out.println(maxSquare);
    }

    private static int findMaxSquare(int[][] arr, int n, int m, int startR, int startC, int rd, int cd) {
        int maxSquare = -1;
        long number = 0;
        int r = startR;
        int c = startC;

        while (r >= 0 && r < n && c >= 0 && c < m) {
            number = number * 10 + arr[r][c];

            if (isPerfectSquare(number)) {
                maxSquare = Math.max(maxSquare, (int) number);
            }

            if (rd == 0 && cd == 0) break;

            r += rd;
            c += cd;
        }

        return maxSquare;
    }

    private static boolean isPerfectSquare(long number) {
        if (number < 0) return false;
        long sqrt = (long) Math.sqrt(number);
        return number == sqrt * sqrt;
    }

}
