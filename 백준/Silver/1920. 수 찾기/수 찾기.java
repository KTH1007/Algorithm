import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		BS bs = new BS();
		Arrays.sort(arr);
		for(int i=0; i<m; i++) {
			if(bs.binarySearch(Integer.parseInt(st.nextToken()),arr) != -1) {
				sb.append(1).append("\n");
			}
			else
				sb.append(0).append("\n");
		}
		System.out.println(sb);
	}
}

//이분탐색
class BS{ 
	public int binarySearch(int key, int[] arr) {
		 
		int lo = 0;	
		int hi = arr.length - 1;	
		while(lo <= hi) {
			int mid = (lo + hi) / 2;	
			if(key < arr[mid]) {  
				hi = mid - 1;
			}
			else if(key > arr[mid]) {
				lo = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
}
