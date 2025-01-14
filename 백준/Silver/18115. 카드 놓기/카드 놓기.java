import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();


        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(sb.append(br.readLine()).reverse().toString());
        sb.setLength(0);
        for (int i = 1; i <= n; i++) {
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                deque.addFirst(i);
            } else if (a == 2) {
                int top = deque.pollFirst();
                deque.addFirst(i);
                deque.addFirst(top);
            } else {
                deque.addLast(i);
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(deque.poll()).append(" ");
        }

        System.out.println(sb);
    }
}
