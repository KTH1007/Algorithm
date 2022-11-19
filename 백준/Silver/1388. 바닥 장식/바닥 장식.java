import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char graph[][] = new char[n][m];
		int count = 0;
		//행 비교
		for(int i=0; i<n; i++) {
			graph[i] = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				if(graph[i][j] == '-') {
					count++;
					// -가 계속 나오면 count 값이 증가하는 것이 아니라 다음 값을 탐색
					while(j<m && graph[i][j] == '-') {
						j++;
					}
				}
			}
		}
		//열 비교
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(graph[j][i] == '|') {
					count++;
					while(j<n && graph[j][i] == '|') {
						j++;
					}
				}
			}
		}
		sb.append(count);
		System.out.println(sb);
	}
}
