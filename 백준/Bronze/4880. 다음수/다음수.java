import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//무한루프
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			//무한루프 종료
			if(A == 0 && B == 0 && C == 0) break;
			
			//값의 차를 저장
			int N = B - A;
			int M = C - B;
			
			//삼항 연산자.
			String result = (N == M) ? ("AP " + (C + M)) : ("GP " + (C + (M * (M / N))));
			
			System.out.println(result);
		}
		
	
	}

}