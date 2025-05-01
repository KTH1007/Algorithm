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

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Deque<Integer>[] stacks = new Deque[7];

        for (int i = 0; i <= 6; i++) {
            stacks[i] = new ArrayDeque<>();
        }

        int count = 0;

        // 줄, 프렛
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            Deque<Integer> stack = stacks[line];

            while (!stack.isEmpty() && stack.peek() > fret) {
                stack.pop();
                count++;
            }

            if (stack.isEmpty() || stack.peek() < fret) {
                stack.push(fret);
                count++;
            }
        }

        System.out.println(count);
    }

}
