import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("O", "X", "X"));
		
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == 'A') {
				Collections.swap(list, 0, 1);
			}else if(S.charAt(i) == 'B') {
				Collections.swap(list, 1, 2);
			}else if(S.charAt(i) == 'C') {
				Collections.swap(list, 0, 2);
			}
		}
		
		System.out.println(list.indexOf("O") + 1);
	}

}