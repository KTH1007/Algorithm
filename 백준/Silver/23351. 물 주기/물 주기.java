import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque();
        for (int i = 0; i < n; i++) {
            queue.add(k);
        }

        int day = 0;

        while (true) {
            if (!check(queue)) break;

            for (int i = 0; i < a; i++) {
                int temp = queue.poll() + b;
                queue.add(temp);
            }

            for (int i = 0; i < n; i++) {
                int temp = queue.poll() - 1;
                queue.add(temp);
            }
            day++;
        }

        System.out.println(day);

    }

    private static boolean check(Queue<Integer> queue) {
        return !queue.contains(0);
    }
}
