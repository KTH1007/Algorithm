import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			String[] split = br.readLine().split(" ");
			if(map.containsKey(split[0])) {
				map.put(split[0], map.get(split[0])+Integer.parseInt(split[1]));
			}
			else {
				map.put(split[0], Integer.parseInt(split[1]));
			}
		}
		if(map.containsValue(5)) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}