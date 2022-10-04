import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static char[][] arr;
	public static int min = 64;  //8*8 체스판의 색상을 모두 변경하는 경우 64
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		//체스판의 가짓수 -> (n-7)*(m-7)개 * 2 처음 시작이 검은색인 경우, 하얀색인 경우
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		for(int i=0; i<n-7; i++) {
			for(int j=0; j<m-7; j++) {
				find(i,j);
			}
		}
		System.out.println(min);
	}
	public static void find(int x, int y) {
		int count = 0;
		char c = arr[x][y]; //첫 번째 칸의 색
		for(int i=x; i<x+8; i++) {
			for(int j=y; j<y+8; j++) {
				if(arr[i][j] != c) {  //올바른 색이 아닌 경우 count++
					count++;
				}//행
				if(c == 'W') {
					c = 'B';
				}
				else {
					c = 'W';
				}  
			}//열
			if(c == 'W') {
				c = 'B';
			}
			else {
				c = 'W';
			}
		}
		count = Math.min(count, 64 - count);  //첫 번째 칸을 기준으로 색칠 할 개수 vs 첫 번째 칸의 반대색을 기준
		min = Math.min(min, count);  //이전까지 최소값보다 더 작은 값이 나올 경우 min에 대입
	}
}