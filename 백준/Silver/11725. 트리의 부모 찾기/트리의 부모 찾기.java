import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer>[] list;
	static boolean[] visited = new boolean[1001];
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		parents = new int[n+1];
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		for(int i=2; i<=n; i++) {
			sb.append(parents[i]+"\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int a) {
		if(visited[a])
			return;
		visited[a] = true;
		for(int i : list[a]) {
			if(!visited[i]) {
				parents[i] = a;
				dfs(i);
			}
		}
	}
}
