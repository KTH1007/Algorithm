import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		long max = 0;
		for(int i=0; i<k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max < arr[i])
				max = arr[i];
		}
		max++;
		long min = 0;
		long mid = 0;  //중간 길이
		while(min < max) {
			mid = (max + min)/2;
			int count = 0;
			for(int i=0; i<arr.length; i++) {
				count += arr[i] / mid;  //총 몇 개 만들어지는지
			}
			if(count < n)
				max = mid;
			else
				min = mid + 1;
		}
		System.out.println(min - 1);
	}
}
