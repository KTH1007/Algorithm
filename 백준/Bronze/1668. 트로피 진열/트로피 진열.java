import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		int count = 0;
		int max = 0;
		
		for (int i=0; i<num; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (i == 0) {
				max = arr[i];
				count++;
				continue;
			}
			if (max < arr[i]) {
				max = arr[i];
				count++;
			}	
		}
		
		bw.write(count+"\n");
		
		count = 1;
		max = arr[num-1];
		for (int i=num-2; i>=0; i--) {
			if (max < arr[i]) {
				max = arr[i];
				count++;
			}		
		}
		bw.write(count+"\n");
		
		bw.flush();
		bw.close();
	}
}