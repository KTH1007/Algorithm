import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(st.nextToken());
		int start = 0;
		for(int i=0; i<n; i++) {
			int m = Integer.parseInt(br.readLine());
			if(m > start) {
				for(int j= start + 1; j<=m; j++) {
					stack.push(j);
					sb.append('+').append("\n");
				}
				start = m;
			}
			else if(stack.peek() != m) {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
			stack.pop();
			sb.append('-').append("\n");
		}
		System.out.println(sb);
	}
}
