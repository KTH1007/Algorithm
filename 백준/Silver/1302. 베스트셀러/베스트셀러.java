import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//hashmap 사용 후 리스트로 변경 -> 정렬 -> max값 출력
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0; i<n; i++) {
			String s = sc.next();
			if(map.containsKey(s)) {
				map.replace(s, map.get(s)+1);
			}
			else {
				map.put(s, 1);
			}
		}
		int max = 0;
		for(String i : map.keySet()) {
			max = Math.max(max, map.get(i));
		}
		ArrayList<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list);
		for(String i : list) {
			if(max == map.get(i)) {
				System.out.println(i);
				break;
			}
		}
		sc.close();
	}
}