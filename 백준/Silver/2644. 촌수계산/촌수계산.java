import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int anser = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int findA = Integer.parseInt(st.nextToken());
		int findB = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
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
		boolean[] visited = new boolean[n + 1];
		dfs(list, visited, findA, findB, 0);
		sb.append(anser);
		System.out.println(sb);
	}
	public static void dfs(ArrayList<ArrayList<Integer>> list, boolean[] visited, int findA, int findB, int count) {
		visited[findA] = true;
		for(int i : list.get(findA)) {
			if(!visited[i]) {
				if(i == findB) {
					anser = count + 1;
					return;
				}
				dfs(list, visited, i, findB, count+1);
			}
		}
	}
}