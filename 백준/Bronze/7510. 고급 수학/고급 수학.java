import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[3];
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());
			
			System.out.println("Scenario #" + i + ":");
			
			Arrays.sort(arr);
			
			if((arr[0] * arr[0]) + (arr[1] * arr[1]) == (arr[2] * arr[2])) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			System.out.println();
		}
	}

}