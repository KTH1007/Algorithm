import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int index = 1;
        while (true) {
            String s = br.readLine();
            if (s.contains("-")) break;
            Deque<Character> stack = new ArrayDeque<>();

            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                if (current == '{') {
                    stack.push(current);
                } else {
                    if (stack.isEmpty()) {
                        stack.push('{');
                        count++;
                    } else {
                        stack.pop();
                    }
                }
            }
            

            int answer = count + stack.size() / 2;
            sb.append(index++).append(". ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

}
