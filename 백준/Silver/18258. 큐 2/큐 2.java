import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            } else if (str.equals("pop")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                } else sb.append(-1).append("\n");
            } else if (str.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (str.equals("empty")) {
                if (queue.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (str.equals("front")) {
                if (!queue.isEmpty()) sb.append(queue.peek()).append("\n");
                else sb.append(-1).append("\n");
            } else {
                if (!queue.isEmpty()) sb.append(queue.peekLast()).append("\n");
                else sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
