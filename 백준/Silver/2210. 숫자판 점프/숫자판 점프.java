import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static int [][] map;
	public static int[] dx = { 1, -1, 0, 0 }; //동서남북
    public static int[] dy = { 0, 0, -1, 1 };
    public static Set<Integer> set = new HashSet<>();  //중복을 없애기 위해 set 사용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		map = new int[5][5];
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				dfs(i,j,0,0);
			}
		}
		sb.append(set.size());
		System.out.println(sb);
	}
	public static void dfs(int x, int y, int count, int sum) {
		sum = (sum*10) + map[x][y]; //수를 이어 붙어야 하기 때문에 바로 앞에 수에 10을 곱해줌
		count++;
		if(count == 6) {
			set.add(sum);
			return;
		}
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx > 4 || ny < 0 || ny > 4) { //동서남북으로 이동이 불가능한 경우
				continue;
			}
			dfs(nx, ny, count, sum);
		}
	}
}