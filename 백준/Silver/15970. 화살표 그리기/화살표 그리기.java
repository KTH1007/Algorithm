import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());

		// 배열을 생성하여 값과 색상을 담는다.
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		// 배열을 오름차순으로 정렬한다.
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				else
					return o1[1] - o2[1];
			}
		});

		// 배열의 첫 번째 인덱스값부터 비교하면서 가까운 색상과 연결한다.
		int sum = 0;
		for(int i=0; i<n; i++) {
			if(i == 0)
				sum += (arr[i+1][0]-arr[i][0]);
			else if(i == n-1) {
				sum += (arr[i][0] - arr[i-1][0]);
			}
			else {
				if(arr[i][1] == arr[i+1][1] && arr[i][1] == arr[i-1][1]) {
					sum += Math.min(arr[i+1][0]-arr[i][0], arr[i][0]-arr[i-1][0]);
				}
				else if(arr[i][1] == arr[i+1][1])
					sum += (arr[i+1][0] - arr[i][0]);
				else
					sum += (arr[i][0] - arr[i-1][0]);
			}
		}
		
		System.out.println(sum);
	}
}