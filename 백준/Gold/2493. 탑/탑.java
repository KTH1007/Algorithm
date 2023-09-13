import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int t = Integer.parseInt(st.nextToken());
            while (true) {
                if (!stack.isEmpty()) {
                    if (stack.peek() > t) {
                        sb.append(index.peek()).append(" ");
                        stack.push(t);
                        index.push(i);
                        break;
                    } else {
                        stack.pop();
                        index.pop();
                    }
                } else {
                    sb.append(0).append(" ");
                    stack.push(t);
                    index.push(i);
                    break;
                }
            }
        }
        System.out.println(sb);

    }


}
