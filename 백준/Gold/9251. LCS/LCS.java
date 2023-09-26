import java.util.Scanner;
 
public class Main { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		char[] s1 = sc.nextLine().toCharArray();
		char[] s2 = sc.nextLine().toCharArray();		
		int xi = s1.length;
		int yj = s2.length;
		
		int[][] c = new int[xi + 1][yj + 1];
		
		for(int i = 1; i <= xi; i++) {
			for(int j = 1; j <= yj; j++) {				
				if(s1[i - 1] == s2[j - 1]) {
					c[i][j] = c[i - 1][j - 1] + 1;	
				}
				else {
					c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
				}
			}
		}
		System.out.println(c[xi][yj]);
		
	}
 
}