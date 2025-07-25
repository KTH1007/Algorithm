import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int e = Integer.parseInt(st.nextToken());	// 가지고 있는 빈병 수
		int f = Integer.parseInt(st.nextToken());	// 발견한 빈병 수
		int c = Integer.parseInt(st.nextToken());	// 새병으로 바꾸는데 필요한 빈병 수
		
		int sum = e + f; // 총 가지고 있는 빈병 수
		int ans = 0;	 // 마실 수 있는 탄산 음료 개수
		while(sum >= c) {
			int mok = sum / c;	// 현재 마실 수 있는 음료수
			ans += mok;			// 현재 마실 수 있는 음료수
			sum = mok + (sum%c); // 이전에 교환해서 마신 음료수 + 빈병
		}
		
		System.out.println(ans);
		bf.close();
	}

}