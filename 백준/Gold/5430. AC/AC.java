import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int t = Integer.parseInt(st.nextToken());
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i=0; i<t; i++) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[],");
			deque = new ArrayDeque<>();
			for(int j=0; j<n; j++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			AC(command, deque);
		}
		System.out.println(sb);
	}
	public static void AC(String command, Deque<Integer> deque) {
		boolean isRight = true;
		for(int i=0; i<command.length(); i++) {
			if(command.charAt(i) == 'R') {
				isRight = !isRight;
			}
			else if(command.charAt(i) == 'D') {
				if(isRight) {
					if(deque.pollFirst() == null) {
						sb.append("error\n");
						return;
					}
				}
				else {
					if(deque.pollLast() == null) {
						sb.append("error\n");
						return;
					}
				}
			}
		}
		Print(deque, isRight);
	}

	public static void Print(Deque<Integer> deque, boolean isRight) {
		sb.append('[');
		if(deque.size() > 0) {
			if(isRight) {
				sb.append(deque.pollFirst());
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}
			else {
				sb.append(deque.pollLast());
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}
		sb.append(']').append("\n");
	}
}
