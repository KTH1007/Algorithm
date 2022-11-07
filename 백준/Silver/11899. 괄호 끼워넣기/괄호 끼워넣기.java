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
		Stack<Character> stack = new Stack<>();
		String s = st.nextToken();
		char[] arr = s.toCharArray();
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == '(') {
				stack.push(arr[i]);
			}
			else {
				if(stack.isEmpty())
					count++;
				else
					stack.pop();
			}
		}
		count += stack.size();
		sb.append(count);
		System.out.println(sb);
	}
}