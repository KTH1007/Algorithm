import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		long sum = 0;
		long pow = 1;
		int m = 1234567891;
		for(int i=0; i<n; i++) {
			sum += (((int)s.charAt(i) - 96) * pow )% m;
			pow = (pow * 31) % m;
		}
		System.out.println(sum % m);
	}
}
