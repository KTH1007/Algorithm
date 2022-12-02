import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			double temp = 100001;
			int price = 0;
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				double d = (double) b/a;
				if(d < temp) {  // b/a가 낮아야 함
					temp = d;
					price = b;
				}
				if(temp == d) {
					if(price>b)
						price = b;
				}
			}
			sb.append(price+"\n");
		}
		System.out.println(sb);
	}
}