import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//int n = Integer.parseInt(st.nextToken());	
		while(true) {
			String s = br.readLine();
			if(s.charAt(s.length()-1) == '.' && s.length() == 1) {
				break;
			}
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == '(' || s.charAt(i) == '[') {
					stack.push(s.charAt(i));
				}
				else if(s.charAt(i) == ')') {
					if(stack.isEmpty() || stack.peek() == '[') {
						stack.push(s.charAt(i));
						break;
					}
					else
						stack.pop();
				}
				else if(s.charAt(i) == ']') {
					if(stack.isEmpty() || stack.peek() == '(') {
						stack.push(s.charAt(i));
						break;
					}
					else
						stack.pop();
				}
			}
			if(stack.isEmpty())
				sb.append("yes").append("\n");
			else
				sb.append("no").append("\n");
		}
		System.out.println(sb);
	}
}