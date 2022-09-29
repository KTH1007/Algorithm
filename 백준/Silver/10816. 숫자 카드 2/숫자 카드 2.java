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
		HashMap<String,Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			String k = st.nextToken();
			if(map.containsKey(k)) {
				map.replace(k, map.get(k)+1);
			}
			else {
				map.put(k, 1);
			}
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<m; i++) {
			String k = st.nextToken();
			if(map.containsKey(k)) {
				sb.append(Integer.toString(map.get(k))).append(" ");
			}
			else {
				sb.append("0 ");
			}
		}
		System.out.println(sb);
	}
}