import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long a, b, ans;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		dfs(a, 1);
		if(ans == 0)
			sb.append(-1);
		else
			sb.append(ans);
		System.out.println(sb);
	}
	
	public static void dfs(long a, int count) {
		if(a>b)
			return;
		if(a == b) {
			ans = count;
			return;
		}
		dfs(a*2, count+1);
		dfs(a*10+1, count+1);
	}
}
