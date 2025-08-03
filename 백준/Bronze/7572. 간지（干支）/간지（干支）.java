import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int y = Integer.parseInt(br.readLine());
		int index10 = 7;
		int index12 = 9;
		
		for (int i = 2; i <= y; i++) {
			index10++; 
			if (index10 == 10) {
				index10 = 0;
			}
			
			index12++; 
			if (index12 == 12) {
				index12 = 0;
			}
		}
		
		char c = (char)(index12 + 'A');
		sb.append(c).append(index10);
		System.out.println(sb);
	}
}
