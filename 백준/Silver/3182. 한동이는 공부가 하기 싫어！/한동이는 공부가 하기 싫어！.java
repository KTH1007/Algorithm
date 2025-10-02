import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int max = 0;
    static int answer = 0;
    static List<Integer>[] list;
    static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        size = n;

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        int idx = 1;
        while (n-- > 0) {
            list[idx++].add(Integer.parseInt(br.readLine()));
        }

        for (int i = 1; i <= size; i++) {
            bfs(i);
        }

        System.out.println(answer);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque();
        queue.add(start);
        boolean[] visited = new boolean[size + 1];
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            if (!visited[current]) {
                visited[current] = true;
                for (int i = 0; i < list[current].size(); i++) {
                    queue.add(list[current].get(i));
                }
            }
        }

        if (count > max) {
            max = count;
            answer = start;
        }
    }
}
