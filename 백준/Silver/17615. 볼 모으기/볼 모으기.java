import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int n;
    static String s;
    static int RCount = 0;
    static int BCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') RCount++;
            else BCount++;
        }

        leftCount('R');
        leftCount('B');
        rightCount('R');
        rightCount('B');

        System.out.println(min);
    }

    private static void leftCount(char color) {
        int leftCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == color) leftCount++;
            else break;
        }

        if (color == 'R') {
            min = Math.min(min, RCount - leftCount);
        } else {
            min = Math.min(min, BCount - leftCount);
        }
    }

    private static void rightCount(char color) {
        int rightCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == color) rightCount++;
            else break;
        }

        if (color == 'R') {
            min = Math.min(min, RCount - rightCount);
        } else {
            min = Math.min(min, BCount - rightCount);
        }
    }
}
