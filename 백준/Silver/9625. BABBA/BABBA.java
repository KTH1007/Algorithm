import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int[] a = new int[n+1];
		int[] b = new int[n+1];
		a[0] = 0;  //버튼 한 번 누른 경우 a의 개수
		a[1] = 1;  //버튼 두 번 누른 경우 a의 개수
		b[0] = 1;  //버튼 한 번 누른 경우 b의 개수
		b[1] = 1;  //버튼 두 번 누른 경우 b의 개수
		for(int i=2; i<=n; i++) {
			a[i] = a[i-2] + a[i-1];  //버튼 3번 -> a 1 b 2 / 4번 -> a 2 b 3
			b[i] = b[i-2] + b[i-1];
		}
		System.out.println(a[n-1] + " " + b[n-1]);
	}
}