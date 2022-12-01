import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		visited[1] = true;
		ArrayList<Integer> list[] = new ArrayList[n + 1];
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		int count = 0;
		dfs(1, list, 0);
		for(int i=2; i<visited.length; i++) {
			if(visited[i])count++;
		}
		sb.append(count);
		System.out.println(sb);
	}

	public static void dfs(int n, ArrayList<Integer>[] list, int depth) {
		if(depth == 2) //친구의 친구까지만 초대 가능
			return;
		for(int i=0; i<list[n].size(); i++) {
			int next = list[n].get(i);
			visited[next] = true;
			dfs(next, list, depth+1);
		}
	}
}
