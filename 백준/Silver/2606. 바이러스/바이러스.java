import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static boolean[] visited;
	static StringBuilder sb;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		dfs(arr,visited,1);
		sb.append(count-1); //1번 컴퓨터 제외
		System.out.println(sb);
	}
	public static void dfs(int[][] arr, boolean[] visited, int v) {
		if(visited[v]) {
			return;
		}
		visited[v] = true;
		count++;
		for(int i=0; i<arr[v].length; i++) {
			if(arr[v][i] == 1 && !visited[i]) {
				dfs(arr,visited,i);
			}
		}
	}
}