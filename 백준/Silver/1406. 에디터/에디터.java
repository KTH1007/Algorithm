import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> leftSt = new Stack<>();
        Stack<Character> rightSt = new Stack<>();
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            leftSt.push(s.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            if (str.equals("L")) {
                if (!leftSt.isEmpty()) rightSt.push(leftSt.pop());
            } else if (str.equals("D")) {
                if (!rightSt.isEmpty()) leftSt.push(rightSt.pop());
            } else if (str.equals("B")) {
                if (!leftSt.isEmpty()) {
                    leftSt.pop();
                }
            } else {
                String temp = st.nextToken();
                leftSt.push(temp.charAt(0));
            }
        }

        while (!leftSt.isEmpty()) {
            rightSt.push(leftSt.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!rightSt.isEmpty()) {
            sb.append(rightSt.pop());
        }

        System.out.println(sb);
    }
}
