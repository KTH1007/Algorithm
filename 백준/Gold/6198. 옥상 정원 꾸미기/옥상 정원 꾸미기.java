import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] buildings = new int[n];

        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        long num = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= buildings[i]) {
                stack.pop();
            }

            num += stack.size();
            stack.push(buildings[i]);
        }

        System.out.println(num);

    }
}
