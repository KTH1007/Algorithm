import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (a == 2) {
                if (!stack.isEmpty()) sb.append(stack.pop()).append("\n");
                else sb.append(-1).append("\n");
            } else if (a == 3) sb.append(stack.size()).append("\n");

            else if (a == 4) {
                if (stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else {
                if (!stack.isEmpty()) sb.append(stack.peek()).append("\n");
                else sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }


}


