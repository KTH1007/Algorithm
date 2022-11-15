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
		String s = br.readLine();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		int value = 1;
		boolean b = true;
		//분배법칙 활용
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(') {
				stack.push(c);
				value *= 2;
			}
			else if(c == '[') {
				stack.push(c);
				value *= 3;
			}
			else {
				if(c == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						b = false;
						break;
					}
					if(s.charAt(i-1) == '(') {
						result += value;
					}
					stack.pop();
					value /= 2;
				}
				else if(c == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						b = false;
						break;
					}
					if(s.charAt(i-1) == '[') {
						result += value;
					}
					stack.pop();
					value /= 3;
				}
				else {
					b = false;
					break;
				}
			}
		}
		if(!b || !stack.isEmpty()){
			sb.append(0);
		}
		else
			sb.append(result);
		System.out.println(sb);
	}
	// result +4 +18 + 6      value 1 2 4 2 6 18 6 2 1 2 6 2 1
}
