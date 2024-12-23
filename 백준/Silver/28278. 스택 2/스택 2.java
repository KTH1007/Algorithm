import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            String s = br.readLine();
            int num;
            if (s.length() > 1) {
                StringTokenizer st = new StringTokenizer(s);
                num = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                stack.push(value);
                continue;
            }
            num = Integer.parseInt(s);
            if (num == 2) {
                if (!stack.isEmpty()) {
                    sb.append(stack.pop()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (num == 3) {
                sb.append(stack.size()).append("\n");
            } else if (num == 4) {
                if (stack.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else {
                if (!stack.isEmpty()) {
                    sb.append(stack.peek()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
