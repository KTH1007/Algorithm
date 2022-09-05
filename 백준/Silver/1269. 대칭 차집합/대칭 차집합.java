import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();			
		HashSet<Integer> hs = new HashSet<Integer>();
		HashSet<Integer> hs2 = new HashSet<Integer>();
		
		for(int i=0; i<n; i++) {
			hs.add(sc.nextInt());
		}
		for(int i=0; i<m; i++) {
			hs2.add(sc.nextInt());
		}
		int cnt = 0;
		for(int i : hs) {
			if(!hs2.contains(i)) {
				cnt++;
			}
		}
		
		for(int i : hs2) {
			if(!hs.contains(i)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		sc.close();
	}
}