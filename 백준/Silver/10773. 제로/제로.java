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
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<n; i++) {
			int k = Integer.parseInt(br.readLine());
			if(!stack.isEmpty() && k == 0) {
				stack.pop();
			}
			else {
				stack.push(k);
			}
		}
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}
