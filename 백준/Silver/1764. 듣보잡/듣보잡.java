import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String ss = bf.readLine();
		StringTokenizer st = new StringTokenizer(ss);
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		//중복일 경우 value에1 더하기 값이 1인 key만 출력
		int cnt = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < a; i++) {
			map.put(bf.readLine(), 0);
		}
		for (int i = 0; i < b; i++) {
			String s = bf.readLine();
			if (map.containsKey(s)) {
				cnt++;
				map.replace(s, map.get(s)+1);
			}
			else {
				map.put(s, 0);
			}
		}
		
		bw.write(Integer.toString(cnt));
		bw.write("\n");
		String[] arr = new String[cnt];
		int j = 0;
		for(String i : map.keySet()) {
			if(map.get(i) == 1) {
				arr[j] = i;
				j++;
			}
		}
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			bw.write(arr[i]);
			bw.write("\n");
		}
		bw.flush();
		bw.close();

	}
}
