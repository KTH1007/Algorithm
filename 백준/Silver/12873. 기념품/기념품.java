import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        for (int i = 1; i < n; i++) {
            int num = (int) ((Math.pow(i, 3) - 1) % deque.size());
            for (int j = 0; j < num; j++) {
                deque.add(deque.poll());
            }
            deque.poll();
        }

        System.out.println(deque.poll());
    }
}
