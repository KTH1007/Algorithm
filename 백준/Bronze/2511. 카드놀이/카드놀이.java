
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		//각 점수를 저장해 줄 변수 선언
		int A = 0;
		int B = 0;
		//무승부가 아닌 승자의 알파벳이 저장될 문자열. 모든 라운드가 동점이면 D가 출력되야 하기에 초기값은 D
		String winner = "D";
		
		for(int i = 0; i < 10; i++) {
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st2.nextToken());
			
			if(N > M) {
				winner = "A";
				A += 3;
			}else if(N < M) {
				winner = "B";
				B += 3;
			}else {
				A += 1;
				B += 1;
			}
		}
		
		if(A > B) {
			System.out.println(A + " " + B);
			System.out.println("A");
		}else if(A < B) {
			System.out.println(A + " " + B);
			System.out.println("B");
		}else {
			System.out.println(A + " " + B);
			System.out.println(winner);
		}
	}

}