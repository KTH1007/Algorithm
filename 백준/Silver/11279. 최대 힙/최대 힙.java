import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<n; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a != 0) {
				pq.add(a);
			}
			else if(a == 0) {
				if(pq.size() == 0) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(pq.peek()).append("\n");
					pq.remove();
				}
				
			}
		}
		System.out.println(sb);
	}
}
