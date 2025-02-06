import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        boolean isRight = false;
        int count = 0;
        int directionCount = 0;

        while (!deque.isEmpty()) {
            int num;
            if (isRight) {
                num = deque.pollLast();
            } else {
                num = deque.pollFirst();
            }

            count++;

            if (count == k) {
                count = 0;
                directionCount++;
                sb.append(num).append("\n");
            } else {
                if (isRight) deque.addFirst(num);
                else deque.addLast(num);
            }

            if (directionCount == m) {
                directionCount = 0;
                isRight = !isRight;
            }
        }

        System.out.println(sb);
    }
}
