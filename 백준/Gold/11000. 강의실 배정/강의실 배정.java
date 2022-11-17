import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0])  //시작 시간이 같으면 종료 시간을 오름차순으로 정렬
					return o1[1] - o2[1]; //두 번째 숫자 기준 오름차순
				return o1[0] - o2[0];  //첫 번째 숫자 기준 오름차순
			}
		});
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(arr[0][1]); //첫 번째로 시작하는 강의 끝나는 시간
		for(int i=1; i<n; i++) {
			if(arr[i][0] >= pq.peek()) {
				pq.poll();
			}
			pq.add(arr[i][1]);
		}
		sb.append(pq.size());
		System.out.println(sb);
	}
}
