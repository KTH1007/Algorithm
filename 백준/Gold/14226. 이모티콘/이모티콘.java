import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class State {
    private int screen;
    private int clipboard;
    private int time;

    public State(int screen, int clipboard, int time) {
        this.screen = screen;
        this.clipboard = clipboard;
        this.time = time;
    }

    public int getScreen() {
        return screen;
    }

    public int getClipboard() {
        return clipboard;
    }

    public int getTime() {
        return time;
    }
}

public class Main {
    static int s;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());
        visited = new boolean[2001][2001];
        bfs();
    }

    private static void bfs() {
        Queue<State> queue = new ArrayDeque<>();
        queue.add(new State(1, 0, 0));
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();
            int screen = current.getScreen();
            int clipboard = current.getClipboard();
            int time = current.getTime();

            if (checkCount(screen)) {
                System.out.println(time);
                return;
            }

            // copy
            if (!visited[screen][screen]) {
                queue.add(new State(screen, screen, time + 1));
                visited[screen][screen] = true;
            }

            // paste
            int newScreen = clipboard + screen;
            if (newScreen <= 2000 && !visited[newScreen][clipboard]) {
                queue.add(new State(newScreen, clipboard, time + 1));
                visited[clipboard][clipboard] = true;
            }

            if (screen > 0 && !visited[screen - 1][clipboard]) {
                queue.add(new State(screen - 1, clipboard, time + 1));
                visited[screen - 1][clipboard] = true;
            }
        }
    }

    private static boolean checkCount(int screen) {
        return s == screen;
    }
}
