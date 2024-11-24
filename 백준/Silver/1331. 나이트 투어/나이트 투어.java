import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> visited = new HashSet<>();

        String start = br.readLine();
        visited.add(start);

        int x = start.charAt(0) - 'A';
        int y = start.charAt(1) - '1';

        int prevX = x;
        int prevY = y;
        boolean isValid = true;

        for (int i = 0; i < 35; i++) {
            String next = br.readLine();
            if (visited.contains(next)) {
                isValid = false;
                break;
            }
            visited.add(next);
            int nextX = next.charAt(0) - 'A';
            int nextY = next.charAt(1) - '1';

            isValid = nightMove(nextX, nextY, prevX, prevY);
            if (!isValid) {
                break;
            }

            prevX = nextX;
            prevY = nextY;
        }

        if (isValid) {
            int startX = start.charAt(0) - 'A';
            int startY = start.charAt(1) - '1';
            if (nightMove(startX, startY, prevX, prevY)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        } else {
            System.out.println("Invalid");
        }
    }

    private static boolean nightMove(int nextX, int nextY, int prevX, int prevY) {
        int[] dx = {2, -2, -2, 2, -1, 1, -1, 1};
        int[] dy = {1, 1, -1, -1, 2, 2, -2, -2};

        for (int i = 0; i < 8; i++) {
            if (prevX + dx[i] == nextX && prevY + dy[i] == nextY) {
                return true;
            }
        }
        return false;
    }
}
