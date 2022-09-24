import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int t = Integer.parseInt(st.nextToken()); //테스트 케이스 개수
		BS bs = new BS();
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int[] narr = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				narr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(narr);
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int[] marr = new int[m];
			st = new StringTokenizer(br.readLine(), " ");
			for(int k=0; k<m; k++) {
				marr[k] = Integer.parseInt(st.nextToken());
			}
			for(int q=0; q<m; q++) {
				if(bs.binarySearch(narr, marr[q]) != false) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}

class BS {
	public boolean binarySearch(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length - 1;
		int mid;
		while (lo <= hi) {
			mid = (lo + hi) / 2;
			if (arr[mid] == key)
				return true;
			else if (arr[mid] < key) {
				lo = mid + 1;
			} else if (arr[mid] > key) {
				hi = mid - 1;
			}
		}
		return false;
	}
}