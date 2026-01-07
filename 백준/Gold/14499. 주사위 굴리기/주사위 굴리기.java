import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Dice {
    private int top;
    private int bottom;
    private int front;
    private int back;
    private int left;
    private int right;

    public Dice(int top, int bottom, int front, int back, int left, int right) {
        this.top = top;
        this.bottom = bottom;
        this.front = front;
        this.back = back;
        this.left = left;
        this.right = right;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    public void updateBottom(int bottom) {
        this.bottom = bottom;
    }

    // 동쪽으로
    public void rollEast() {
        int prevRight = right;
        int prevLeft = left;
        int prevBottom = bottom;
        int prevTop = top;

        bottom = prevRight;
        left = prevBottom;
        top = prevLeft;
        right = prevTop;
    }

    // 서쪽으로
    public void rollWest() {
        int prevRight = right;
        int prevLeft = left;
        int prevBottom = bottom;
        int prevTop = top;

        top = prevRight;
        right = prevBottom;
        bottom = prevLeft;
        left = prevTop;
    }

    // 북쪽으로
    public void rollNorth() {
        int prevFront = front;
        int prevBack = back;
        int prevBottom = bottom;
        int prevTop = top;

        front = prevBottom;
        top = prevFront;
        back = prevTop;
        bottom = prevBack;
    }

    // 남쪽으로
    public void rollSouth() {
        int prevFront = front;
        int prevBack = back;
        int prevBottom = bottom;
        int prevTop = top;

        back = prevBottom;
        top = prevBack;
        front = prevTop;
        bottom = prevFront;
    }
}

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int n, m;
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");

        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);

        int x = Integer.parseInt(tokens[2]);
        int y = Integer.parseInt(tokens[3]);

        int k = Integer.parseInt(tokens[4]);

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        int[] arr = new int[k];
        tokens = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        move(arr, x, y);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append("\n");
        }

        System.out.println(sb);
    }

    private static void move(int[] arr, int x, int y) {
        Dice dice = new Dice(0, 0, 0, 0, 0, 0);

        for (int i = 0; i < arr.length; i++) {
            int direction = arr[i];

            int[] currentXandY = processDiceRoll(dice, direction, x, y);

            int nx = currentXandY[0];
            int ny = currentXandY[1];

            if (nx == -1 && ny == -1) {
                continue;
            }

            if (map[nx][ny] == 0) {
                map[nx][ny] = dice.getBottom();
            } else {
                dice.updateBottom(map[nx][ny]);
                map[nx][ny] = 0;
            }

            queue.add(dice.getTop());
            x = nx;
            y = ny;
        }
    }

    private static int[] processDiceRoll(Dice dice, int direction, int x, int y) {
        int nx = x + dx[direction - 1];
        int ny = y + dy[direction - 1];

        if (!validateSize(nx, ny)) {
            return new int[]{-1, -1};
        }

        if (direction == 1) {
            dice.rollEast();
        } else if (direction == 2) {
            dice.rollWest();
        } else if (direction == 3) {
            dice.rollNorth();
        } else {
            dice.rollSouth();
        }

        return new int[]{nx, ny};
    }

    private static boolean validateSize(int nx, int ny) {
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
            return false;
        }

        return true;
    }
}
