import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Integer> num = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                num.push(c - '0');
            } else {
                int b = num.pop();
                int a = num.pop();

                if (c == '+') {
                    num.push(a + b);
                } else if (c == '-') {
                    num.push(a - b);
                } else if (c == '*') {
                    num.push(a * b);
                } else {
                    num.push(a / b);
                }
            }
        }

        System.out.println(num.pop());
    }

}
