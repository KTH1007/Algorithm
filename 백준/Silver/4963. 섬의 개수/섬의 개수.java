import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static boolean visited[][];
	public static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};  //상 하 좌 우 상좌 상우 하좌 하우
	public static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1}; //상 하 좌 우 상좌 상우 하좌 하우
	public static int w, h, nowX, nowY;
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0)
				break;
			arr = new int[h][w];
			visited = new boolean[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(!visited[i][j] && arr[i][j] == 1) {
						count++;
						dfs(i,j);
					}
				}
			}
			sb.append(count+"\n");
		}
		
		System.out.println(sb);
	}
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<8; i++) {
			nowX = x + dx[i];
			nowY = y + dy[i];
			if(nowX < 0 || nowY < 0 || nowX >= h || nowY >= w) {
				continue;
			}
			if(!visited[nowX][nowY] && arr[nowX][nowY] == 1) {
				dfs(nowX, nowY);
			}
		}
		
	}
}