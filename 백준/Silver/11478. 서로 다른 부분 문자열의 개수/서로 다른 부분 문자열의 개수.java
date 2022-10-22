import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//int n = Integer.parseInt(st.nextToken());
		String s = st.nextToken();
		HashSet<String> set = new HashSet<String>();
		for(int i=0; i<=s.length(); i++) {
			for(int j=i+1; j<=s.length(); j++) {
				set.add(s.substring(i,j));
			}
		}
		System.out.println(set.size());
	}
}
