import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,v;
	static boolean[] visited;
	static List<List<Integer>> list = new ArrayList<>();
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		for (int i = 1; i <= n; i++) {
			Collections.sort(list.get(i));
		}
		visited = new boolean[n+1];
		DFS(v);
		sb.append("\n");
		Arrays.fill(visited, false);
		BFS(v);
		System.out.println(sb);
	}
	public static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;
		while(!queue.isEmpty()) {
			int a = queue.poll();
			sb.append(a+" ");
			for(int i=0; i<list.get(a).size(); i++) {
				int next = list.get(a).get(i);
				if(visited[next])
					continue;
				queue.add(next);
				visited[next] = true;
			}
		}
	}
	public static void DFS(int v) {
		if(visited[v])
			return;
		visited[v] = true;
		sb.append(v + " ");
		for(int i=0; i<list.get(v).size(); i++) {
			if(!visited[list.get(v).get(i)]) {
				DFS(list.get(v).get(i));
			}
		}
	}
}