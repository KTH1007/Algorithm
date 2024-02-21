import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();


        for (int i = 1; i <= n; i++) {
            int t = Integer.parseInt(st.nextToken());

            while (true) {
                if (stack.isEmpty()) {
                    sb.append(0).append(" ");
                    stack.push(t);
                    index.push(i);
                    break;
                } else {
                    if (stack.peek() > t) {
                        sb.append(index.peek()).append(" ");
                        stack.push(t);
                        index.push(i);
                        break;
                    } else {
                        stack.pop();
                        index.pop();
                    }
                }
            }
        }
        System.out.println(sb);
    }

}
