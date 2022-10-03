import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//int n = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {   //열린 괄호가 나올 때마다 막대기가 하나 만들어짐
				stack.push('(');
			}
			if(s.charAt(i) == ')') {
				stack.pop();
				if(s.charAt(i-1) == '(') {  //레이저
					result += stack.size();
				}
				else {  //앞이 닫힌 괄호면 레이저가 아님 그 막대기의 길이가 끝
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}