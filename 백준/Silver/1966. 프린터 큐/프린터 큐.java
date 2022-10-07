import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
 
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int k=0; k<t; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			LinkedList<int[]> q = new LinkedList<>();	// 큐 대신 사용
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				// 초기 위치, 중요도
				q.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}
			int count = 0;
			while (!q.isEmpty()) {
				int[] front = q.poll();
				boolean isMax = true;
				//중요도 비교
				for(int i = 0; i < q.size(); i++) {
					if(front[1] < q.get(i)[1]) {
						q.offer(front);
						for(int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						isMax = false;
						break;
					}
				}
				if(isMax == false) {
					continue;
				}
				count++;
				if(front[0] == m) {
					break;
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}
 
}
