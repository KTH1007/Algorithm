import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int x = Integer.parseInt(st.nextToken());
                deque.addFirst(x);
            } else if (a == 2) {
                int x = Integer.parseInt(st.nextToken());
                deque.addLast(x);
            } else if (a == 3) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.pollFirst()).append("\n");
            } else if (a == 4) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.pollLast()).append("\n");
            } else if (a == 5) {
                sb.append(deque.size()).append("\n");
            } else if (a == 6) {
                if (deque.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (a == 7) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.peekFirst()).append("\n");
            } else if (a == 8) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.peekLast()).append("\n");
            }
        }

        System.out.println(sb);

    }


}


