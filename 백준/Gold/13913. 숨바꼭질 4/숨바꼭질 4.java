import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {
    static int min = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);

        bfs(n, k);
        System.out.println(min);
        System.out.println(sb);
    }

    private static void bfs(int n, int k) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{n, 0});
        int[] visited = new int[100_001];
        int[] parent = new int[100_001];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            if (time > min) {
                continue;
            }
            
            if (position == k) {
                min = Math.min(min, time);

                sb.setLength(0);
                Deque<Integer> stack = new ArrayDeque<>();
                int currentPosition = k;

                while (currentPosition != n) {
                    stack.push(currentPosition);
                    currentPosition = parent[currentPosition];
                }

                stack.push(n);

                while (!stack.isEmpty()){
                    sb.append(stack.pop()).append(" ");
                }
            }

            int nextTime = time + 1;

            if (position - 1 >= 0 ) {
                if (visited[position - 1] == 0) {
                    visited[position - 1] = nextTime;
                    parent[position - 1] = position;
                    queue.add(new int[]{position - 1, nextTime});
                } else if (visited[position - 1] == nextTime) {
                    queue.add(new int[]{position - 1, nextTime});
                }
            }

            if (position + 1 < 100_001) {
                if (visited[position + 1] == 0) {
                    visited[position + 1] = nextTime;
                    parent[position + 1] = position;
                    queue.add(new int[]{position + 1, nextTime});
                } else if (visited[position + 1] == nextTime) {
                    queue.add(new int[]{position + 1, nextTime});
                }
            }

            if (position * 2 < 100_001) {
                if (visited[position * 2] == 0) {
                    visited[position * 2] = nextTime;
                    parent[position * 2] = position;
                    queue.add(new int[]{position * 2, nextTime});
                } else if (visited[position * 2] == nextTime) {
                    queue.add(new int[]{position * 2, nextTime});
                }
            }

        }
    }
}
