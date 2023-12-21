import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = n - 1; i >= 0; i--) stack.push(arr[i]);

        Stack<Integer> temp = new Stack<>();

        int i = 1;
        while (true) {
            if (!stack.isEmpty() && stack.peek() == i) {
                i++;
                stack.pop();
            } else if (!temp.isEmpty() && temp.peek() == i) {
                i++;
                temp.pop();
            } else {
                if (stack.isEmpty()) break;
                else {
                    temp.push(stack.pop());

                }
            }
        }

        if (i - 1 == n) System.out.println("Nice");
        else System.out.println("Sad");
    }


}


