import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		String[] s = new String[n];
		for(int i=0; i<n; i++) {
			s[i] = sc.next();
		}

		Arrays.sort(s);
		Arrays.sort(s, (String s1, String s2) -> s1.length() - s2.length());

		System.out.println(s[0]);
		for(int i=1; i<n; i++) {
			if(!s[i].equals(s[i-1])) {
				System.out.println(s[i]);
			}
		}

		sc.close();
		}
}
