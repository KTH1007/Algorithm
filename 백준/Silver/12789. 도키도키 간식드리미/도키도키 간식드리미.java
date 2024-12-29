import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int seq = 1;

        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < n; i++) {
            if (arr[i] == seq) {
                seq++;
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == seq) {
                stack.pop();
                seq++;
                i--;
            }
            else {
                stack.push(arr[i]);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() != seq) {
                System.out.println("Sad");
                return;
            } else {
                stack.pop();
                seq++;
            }
        }

        System.out.println("Nice");
    }
}
