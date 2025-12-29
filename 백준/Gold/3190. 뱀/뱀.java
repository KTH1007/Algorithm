import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Dire {
    private int time;
    private String direction;

    public Dire(int time, String direction) {
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return time;
    }

    public String getDirection() {
        return direction;
    }
}

public class Main {
    static int n;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int gameTime = 0;
    static int direction = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        map = new int[n][n];

        String[] tokens;
        for (int i = 0; i < k; i++) {
            tokens = br.readLine().split(" ");
            int x = Integer.parseInt(tokens[0]) - 1;
            int y = Integer.parseInt(tokens[1]) - 1;

            map[x][y] = 1;
        }

        int l = Integer.parseInt(br.readLine());

        Queue<Dire> queue = new ArrayDeque<>();
        for (int i = 0; i < l; i++) {
            tokens = br.readLine().split(" ");
            int time = Integer.parseInt(tokens[0]);
            String direction = tokens[1];
            queue.add(new Dire(time, direction));
        }

        snake(queue);
        System.out.println(gameTime);
    }

    private static void snake(Queue<Dire> queue) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0, direction});
        int time = 0;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (true) {
            time++;
            int[] current = deque.peekLast();
            int x = current[0];
            int y = current[1];

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                gameTime = time;
                break;
            }

            deque.add(new int[]{nx, ny, direction});
            visited[nx][ny] = true;

            if (map[nx][ny] != 1) {
                int[] prev = deque.pollFirst();
                int prevX = prev[0];
                int prevY = prev[1];
                visited[prevX][prevY] = false;
            }

            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
            }

            if (!queue.isEmpty() && queue.peek().getTime() == time) {
                String stringDire = queue.poll().getDirection();

                if (stringDire.equals("L")) {
                    direction--;
                    if (direction < 0) {
                        direction = 3;
                    }
                } else {
                    direction = (direction + 1) % dx.length;
                }
            }
        }
    }
}
