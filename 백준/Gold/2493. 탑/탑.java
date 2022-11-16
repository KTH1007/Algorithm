import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();  //위치 저장을 위한 스택
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=n; i++) {
			int t = Integer.parseInt(st.nextToken());
			while(true) {
				if(!stack.isEmpty()) {
					if(stack.peek() > t) {
						sb.append(index.peek()+" ");
						stack.push(t);
						index.push(i);
						break;
					}
					else {
						stack.pop();
						index.pop();
					}
				}
				else {
					sb.append(0+" ");
					stack.push(t);
					index.push(i);
					break;
				}
			}
		}
		//index  1push 1pop 2push 3push 3pop 4push 5push
		//sb        0          0     2         2      4
		System.out.println(sb);
	}
}
