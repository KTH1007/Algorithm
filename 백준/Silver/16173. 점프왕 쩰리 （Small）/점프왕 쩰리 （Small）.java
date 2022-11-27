import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0,1}, dy = {1,0};
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = false;
			}
		}
		sb.append("Hing");
		dfs(0,0);
		System.out.println(sb);
	}
	public static void dfs(int i, int j) {
		if(arr[i][j] == -1) {
			sb.setLength(0);
			sb.append("HaruHaru");
			return;
		}
		for(int k=0; k<2; k++) {
			int x = i + dx[k] * arr[i][j];
			//System.out.println("i: " + i + " dx: "+ dx[k] + " arr: " + arr[i][j] + " x: " + x);
			int y = j + dy[k] * arr[i][j];
			//System.out.println("j: " + j + " dy: "+ dy[k] + " arr: " + arr[i][j] + " y: " + y);
			//System.out.println();
			if(n <= x || n <= y || visited[x][y])
				continue;
			visited[x][y] = true;
			dfs(x, y);
		}
	}
}