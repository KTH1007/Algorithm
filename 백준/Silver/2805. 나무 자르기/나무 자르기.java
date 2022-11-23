import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[n];
		st = new StringTokenizer(br.readLine(), " ");
		int min = 0;
		int max = 0;
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i])
				max = arr[i];
		}
		//UpperBound 방식을 사용했기 때문에 원하는 탐색 값 +1이 나옴
		while(min < max) {
			int mid = (max + min) / 2;
			long sum = 0;
			for(int i : arr) {
				if(i - mid >0) {
					sum += i - mid;
				}
			}
			if(sum < m) {  //자르는 높이를 낮춰야 나무 길이가 길어짐
				max = mid;
			}
			else{
				min = mid + 1;  //mid값은 이미 안 된다는 것을 확인함
			}
		}
		sb.append(min-1);
		System.out.println(sb);
	}
}
