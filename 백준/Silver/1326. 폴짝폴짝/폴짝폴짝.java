import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] bridge;
    static int[] visited;
    static int n, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bridge = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int answer = findMinJumps();
        System.out.println(answer);
    }

    private static int findMinJumps() {
        visited = new int[n + 1];
        Arrays.fill(visited, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(a);
        visited[a] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == b) {
                return visited[b];
            }

            // 가능한 경로 탐색
            forwardJump(current, visited, queue);
            backJump(current, visited, queue);
        }

        // b에 도달이 불가능한 경우
        return -1;
    }


    private static void forwardJump(int current, int[] visited, Queue<Integer> queue) {
        for (int i = 1; current + bridge[current] * i <= n; i++) {
            int next = current + bridge[current] * i;
            if (visited[next] == -1) {
                visited[next] = visited[current] + 1;
                queue.offer(next);
            } else {
                visited[next] = Math.min(visited[next], visited[current] + 1);
            }
        }
    }

    private static void backJump(int current, int[] visited, Queue<Integer> queue) {
        for (int i = 1; current - bridge[current] * i > 0; i++) {
            int next = current - bridge[current] * i;
            if (visited[next] == -1) {
                visited[next] = visited[current] + 1;
                queue.offer(next);
            } else {
                visited[next] = Math.min(visited[next], visited[current] + 1);
            }
        }
    }
}
