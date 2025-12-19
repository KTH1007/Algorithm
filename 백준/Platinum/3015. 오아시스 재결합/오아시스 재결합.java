import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<int[]> stack = new ArrayDeque<>();
        long count = 0;

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek()[0] < height) {
                count += stack.pop()[1];
            }

            if (stack.isEmpty()) {
                stack.push(new int[]{height, 1});
            } else if (stack.peek()[0] > height) {
                stack.push(new int[]{height, 1});
                count++;
            } else {
                int[] same = stack.pop();
                count += same[1];

                if (!stack.isEmpty()) {
                    count++;
                }

                stack.push(new int[]{height, same[1] + 1});
            }
        }
        System.out.println(count);
    }

}
