import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static int min = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    static int totalCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);

        bfs(n, k);

        System.out.println(min);
        System.out.println(totalCount);
    }

    private static void bfs(int n, int k) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{n, 0});
        int[] visited = new int[100_001];
        Arrays.fill(visited, -1);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            if (time > min) {
                continue;
            }

            if (position == k) {
                if (time == min) {
                    totalCount++;
                } else if (time < min){
                    min = time;
                    totalCount = 1;
                }
            }


            if (position - 1 >= 0) {
                if (visited[position - 1] == -1) {
                    visited[position - 1] = time + 1;
                    queue.add(new int[]{position - 1, time + 1});
                } else if (visited[position - 1] == time + 1) {
                    queue.add(new int[]{position - 1, time + 1});
                }
            }

            if (position + 1 < 100_001) {
                if (visited[position + 1] == -1) {
                    visited[position + 1] = time + 1;
                    queue.add(new int[]{position + 1, time + 1});
                } else if (visited[position + 1] == time + 1) {
                    queue.add(new int[]{position + 1, time + 1});
                }
            }

            if (position * 2 < 100_001) {
                if (visited[position * 2] == -1) {
                    visited[position * 2] = time + 1;
                    queue.add(new int[]{position * 2, time + 1});
                } else if (visited[position * 2] == time + 1) {
                    queue.add(new int[]{position * 2, time + 1});
                }
            }
        }
    }
}
