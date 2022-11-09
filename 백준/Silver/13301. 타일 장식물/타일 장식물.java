import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		long[] arr = new long[80];
		arr[0] = 1;
		arr[1] = 1;
		for(int i=2; i<80; i++) {
			arr[i] = arr[i-2] + arr[i-1];
		}
		ArrayList<Long> list = new ArrayList<>();
		list.add((long)4);
		for(int i=1; i<80; i++) {
			list.add(list.get(i-1)+2*arr[i]);
		}
		sb.append(list.get(n-1));
		System.out.println(sb);
	}
}
