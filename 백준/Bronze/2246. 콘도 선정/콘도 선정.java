import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;	// 후보 콘도의 갯수
		
		for(int i=0; i<N; i++) {
			boolean flag = true;
			for(int j=0; j<N; j++) {
				
				if(i == j)
					continue;
				
				if(arr[i][0] >= arr[j][0]) {
					if(arr[i][1] >= arr[j][1]) {
						flag = false;
						continue;
					}
				}
				
				if(arr[i][1] >= arr[j][1]) {
					if(arr[i][0] >= arr[j][0]) {
						flag = false;
						continue;
					}
				}
			}
			if(flag)
				count ++;
		}
		
		bw.write(count + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}