import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') stack.push(c);
                else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
                else if (c == ')') stack.push(c);
            }
            if (stack.isEmpty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }
}
