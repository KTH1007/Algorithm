import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] cookie = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                cookie[i][j] = s.charAt(j);
            }
        }

        int[] heart = findHeart(n, cookie);
        int[] waist = findWaist(n, cookie, heart);
        int waistLength = waist[0] - heart[0];
        StringBuilder sb = new StringBuilder();
        sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n")
                .append(findLeftArmLength(n, cookie, heart)).append(" ")
                .append(findRightArmLength(n, cookie, heart)).append(" ")
                .append(waistLength).append(" ")
                .append(findLeftLegLength(n, cookie, waist)).append(" ")
                .append(findRightLegLength(n, cookie, waist));
        System.out.println(sb);
    }

    private static int[] findHeart(int n, char[][] cookie) {
        int[] coordinate = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cookie[i][j] == '*') {
                    coordinate[0] = i + 1;
                    coordinate[1] = j;
                    return coordinate;
                }
            }
        }

        return coordinate;
    }

    private static int findLeftArmLength(int n, char[][] cookie, int[] heart) {
        int count = 0;
        int x = heart[0];
        int y = heart[1];
        for (int i = 0; i < y; i++) {
            if (cookie[x][i] == '*') count++;
        }
        return count;
    }

    private static int findRightArmLength(int n, char[][] cookie, int[] heart) {
        int count = 0;
        int x = heart[0];
        int y = heart[1];
        for (int i = y + 1; i < n; i++) {
            if (cookie[x][i] == '*') count++;
        }
        return count;
    }

    private static int[] findWaist(int n, char[][] cookie, int[] heart) {
        int[] coordinate = new int[2];
        int x = heart[0] + 1;
        int y = heart[1];
        for (int i = x; i < n; i++) {
            if (cookie[i][y] == '_') {
                coordinate[0] = i - 1;
                coordinate[1] = y;
                break;
            }
        }
        return coordinate;
    }

    private static int findLeftLegLength(int n, char[][] cookie, int[] waist) {
        int count = 0;
        int x = waist[0] + 1;
        int y = waist[1] - 1;
        for (int i = x; i < n; i++) {
            if (cookie[i][y] == '*') count++;
        }
        return count;
    }

    private static int findRightLegLength(int n, char[][] cookie, int[] waist) {
        int count = 0;
        int x = waist[0] + 1;
        int y = waist[1] + 1;
        for (int i = x; i < n; i++) {
            if (cookie[i][y] == '*') count++;
        }
        return count;
    }
}
