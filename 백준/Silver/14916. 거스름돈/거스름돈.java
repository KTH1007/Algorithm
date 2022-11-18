import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int count = 0;
		while(n != 0) {
			if(n%5 == 0) {
				count += n/5;
				break;
			}
			n -= 2;
			count++;
		}
		if(n<0) {
			count = -1;
		}
		sb.append(count);
		System.out.println(sb);
	}
}