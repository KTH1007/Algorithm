import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		HashMap<Long,Integer> map = new HashMap<Long,Integer>();
		for(int i=0; i<n; i++) {
			long a = Long.parseLong(br.readLine());
			map.put(a, map.getOrDefault(a,0)+1);
		}
		int max = 0;
		long as = 0;
		for(long k : map.keySet()) {
			if(map.get(k) > max) {
				max = map.get(k);
				as = k;
			}
			else if(map.get(k) == max) {
				as = Math.min(as, k);
			}
		}
		System.out.println(as);
	}
}
