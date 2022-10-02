import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			HashMap<String,Integer> map = new HashMap<String,Integer>(); //종류, 개수
			int k = Integer.parseInt(br.readLine());
			for(int j=0; j<k; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken(); //옷 이름은 버림
				String kind = st.nextToken(); //옷 종류
				if(map.containsKey(kind)) {
					map.put(kind, map.get(kind) + 1);
				}
				else {
					map.put(kind, 1);
				}
			}
			int result = 1;
			for(int v : map.values()) {
				result *= v+1;  // 안 입는 경우를 포함
			}
			sb.append(result-1).append("\n");
		}
		System.out.println(sb);
	}
}