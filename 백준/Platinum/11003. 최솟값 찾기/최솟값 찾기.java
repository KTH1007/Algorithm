import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]);
        int l = Integer.parseInt(tokens[1]);

        int[] arr = new int[n];

        tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        Deque<int[]> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst()[1] < i - l + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && deque.peekLast()[0] > arr[i]) {
                deque.pollLast();
            }

            deque.add(new int[]{arr[i], i});
            sb.append(deque.peek()[0]).append(" ");
        }

        System.out.println(sb);
    }

}
