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
		int m = Integer.parseInt(st.nextToken());
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0; i<n; i++) {
			map.put(br.readLine(), 0);
		}
		int count=0;
		for(int i=0; i<m; i++) {
			if(map.containsKey(br.readLine()) == true) {
				count++;
			}
		}
		System.out.println(count);
	}
}
