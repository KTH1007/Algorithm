import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st =new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			q.offer(i);
		}
		while(q.size() != 1) {
			q.remove();
			q.offer(q.peek());
			q.remove();
		}
		sb.append(q.poll());
		System.out.println(sb);
	}
}
