import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			for (int j = 0; j < s.length(); j++) {
				if (!stack.isEmpty() && stack.peek() == s.charAt(j)) {
					stack.pop();
				} else
					stack.push(s.charAt(j));
			}
			if (stack.isEmpty())
				cnt++;
		}
		System.out.println(cnt);
	}
}