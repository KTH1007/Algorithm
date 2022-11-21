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
		int t = Integer.parseInt(st.nextToken());
		//간선의 개수 = 정점의 개수 - 1
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			for(int j=0; j<m; j++) {
				br.readLine();
			}
			sb.append(n-1).append("\n");
		}
		System.out.println(sb);
	}
}

