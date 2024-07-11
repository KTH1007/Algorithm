import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int decimalNum = 0;
        for (int i = m - 1; i >= 0; i--) {
            int n = Integer.parseInt(st.nextToken());

            decimalNum += n * Math.pow(a, i);
        }

        Stack<Integer> stack = new Stack<>();

        while (decimalNum != 0) {
            stack.push(decimalNum % b);
            decimalNum /= b;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

}
