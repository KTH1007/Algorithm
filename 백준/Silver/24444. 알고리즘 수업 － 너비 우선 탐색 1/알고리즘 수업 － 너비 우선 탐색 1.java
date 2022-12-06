import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, r;
	static List<List<Integer>> list = new ArrayList<>();
	static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		visited = new int[n+1];
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
		for(int i=1; i<=n; i++) {
			Collections.sort(list.get(i));
		}
		bfs(r);
		for(int i=1; i<=n; i++) {
			sb.append(visited[i]+"\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs(int r) {
		Queue<Integer> queue = new LinkedList<>();
		int cnt = 1;
		queue.add(r);
		visited[r] = cnt++;
		while(!queue.isEmpty()) {
			int c = queue.poll();
			for(int i=0; i<list.get(c).size(); i++) {
				int next = list.get(c).get(i);
				if(visited[next] != 0)
					continue;
				queue.add(next);
				visited[next] = cnt++;
			}
		}
	}
}