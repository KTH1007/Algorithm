import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String s = br.readLine();
		Stack<Character> stack = new Stack<>();
		boolean b = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				b = false;
			}
			if(s.charAt(i) == '>') {
				sb.append(s.charAt(i));
				b = true;
				continue;  //continue를 쓰지 않으면 다음 if문에서 '>'를 스택에 넣게 됨
			}
			if(s.charAt(i) == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(s.charAt(i));
				continue;
			}
			//true인 경우에는 거꾸로 출력하고 false인 경우에는 순서대로 출력
			if (b == true) {
				stack.push(s.charAt(i));
			}
			else if(b == false) {
				sb.append(s.charAt(i));
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}