import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);

        int[] v = new int[n];
        tokens = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(tokens[i]);
        }

        Arrays.sort(v);

        Deque<int[]> deque = new ArrayDeque<>();
        int windowSize = n - k;
        int m = windowSize - 1;

        for (int i = 0; i < n - 1; i++) {
            int[] now = new int[]{i, v[i + 1] - v[i]};

            if (!deque.isEmpty() && deque.peekFirst()[0] <= i - m) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && deque.peekLast()[1] > now[1]) {
                deque.removeLast();
            }

            deque.add(now);

            if (i + 1 >= m) {
                int m_value = deque.peekFirst()[1];
                int M_value = v[i + 1] - v[i + 1 - m];
                min = Math.min(min, M_value + m_value);
            }
        }

        System.out.println(min);
    }

}
