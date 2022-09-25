import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static int n;   //static 변수로 선언하여 메모리 할당
	public static int k;
	public static boolean[] visited;
	public static HashSet<String> hs;
	public static String[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());	
		k = Integer.parseInt(br.readLine());
		arr = new String[n];
		hs = new HashSet<String>();
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		choice(k, "");
		sb.append(Integer.toString(hs.size()));
		System.out.println(sb);
	}
	public static void choice(int k, String s) {
		if(k == 0) {
			hs.add(s);  //재귀함수를 사용하다가 k만큼 카드를 뽑으면 HashSet에 추가
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visited[i]) {  //방문하지 않은 인덱스일 경우
				visited[i] = true;
				choice(k-1, s+arr[i]);
				visited[i] = false;  //재귀 끝나고 반복문으로 돌아오면 false로 바꾸기
			}
		}
	}
}