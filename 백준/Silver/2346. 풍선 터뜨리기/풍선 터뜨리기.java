import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<int[]> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            deque.add(new int[]{Integer.parseInt(st.nextToken()), i});
        }

        int num = deque.peekFirst()[0];
        int index = deque.peekFirst()[1];
        sb.append(index).append(" ");

        deque.poll();

        while (!deque.isEmpty()) {
            if (num > 0) {
                for (int i = 0; i < num - 1; i++) {
                    deque.add(deque.poll());
                }
                num = deque.peekFirst()[0];
                index = deque.peekFirst()[1];

                deque.poll();
            } else {
                num *= -1;
                for (int i = 0; i < num - 1; i++) {
                    deque.addFirst(deque.pollLast());
                }
                num = deque.peekLast()[0];
                index = deque.peekLast()[1];

                deque.pollLast();
            }

            sb.append(index).append(" ");
        }

        System.out.println(sb);


    }
}
