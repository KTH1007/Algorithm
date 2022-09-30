import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		Deque<String> deque = new ArrayDeque<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String k = st.nextToken();
			if(k.equals("push")) {
				deque.add(st.nextToken());
			}
			else if(k.equals("pop")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(deque.pollFirst());;
				}
			}
			else if(k.equals("size")) {
				System.out.println(deque.size());
			}
			else if(k.equals("empty")) {
				if(deque.isEmpty()) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
			}
			else if(k.equals("front")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(deque.getFirst());
				}
			}
			else if(k.equals("back")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(deque.getLast());
				}
			}
		}
		//System.out.println(sb);
	}
}