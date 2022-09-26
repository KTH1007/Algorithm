import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());	
		for(int j=0; j<n; j++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == '(') {
					stack.push(s.charAt(i));
				}
				else if(s.charAt(i) == ')') {
					if(stack.isEmpty()) {
						stack.push(s.charAt(i));
						break;
					}
					else
						stack.pop();
				}
			}
			if(stack.isEmpty())
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}
}