import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				//앞의 값이 더 크면 자리 변경
				if(Math.abs(a) > Math.abs(b)) {
					return Math.abs(a) - Math.abs(b);
				}
				//절대값이 같으면 음수를 앞으로
				else if(Math.abs(a) == Math.abs(b)) {
					return a-b;
				}
				else {
					return -1;
				}
			}
		});
		for(int i=0; i<n; i++) {
			int k = Integer.parseInt(br.readLine());
			if(k == 0) {
				if(pq.isEmpty()) {
					sb.append("0").append("\n");
				}
				else
					sb.append(pq.poll()).append("\n");
			}
			else
				pq.add(k);
		}
		System.out.println(sb);
	}
}
