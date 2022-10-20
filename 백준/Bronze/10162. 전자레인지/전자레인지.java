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
		int a = 300;
		int b = 60;
		int c = 10;
		int[] arr = new int[3];
		arr[0] = n/a;
		n = n%a;
		arr[1] = n/b;
		n = n%b;
		arr[2] = n/c;
		sb.append(arr[0]+" ").append(arr[1]+" ").append(arr[2]);
		if(n%c != 0) {
			sb.setLength(0);
			sb.append(-1);
		}
		System.out.println(sb);
	}
}
