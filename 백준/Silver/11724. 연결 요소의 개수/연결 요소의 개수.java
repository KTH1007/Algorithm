import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] graph = new int[1001][1001];
	static boolean[] visited = new boolean[1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = 1;
			graph[v][u] = 1;
		}
		int result = 0;
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				dfs(i);
				result++;
			}
		}
		sb.append(result);
		System.out.println(sb);
	}
	public static void dfs(int index) {
		if(visited[index])
			return;
		visited[index] = true;
		for(int i=1; i<=n; i++) {
			if(graph[index][i] == 1) {
				dfs(i);
			}
		}
	}
}