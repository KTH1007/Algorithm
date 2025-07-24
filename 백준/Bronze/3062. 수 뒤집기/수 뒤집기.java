import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

		int N = Integer.parseInt(br.readLine()); 
		
		for(int i = 0; i < N; i++) {
			String numSet = br.readLine();
			String reverse = "";
			String check = null;
            
			for(int j = numSet.length()-1; j>=0; j--) { 
				reverse = reverse+numSet.charAt(j);
			}
            
			int sum = Integer.parseInt(numSet)+Integer.parseInt(reverse); 
			String sumSet = Integer.toString(sum); 
			
			for(int j = 0; j<(sumSet.length()/2); j++) {
				char left =sumSet.charAt(j);
				char right =sumSet.charAt(sumSet.length()-j-1);
				
				if(left!=right) {
					check = "PASS";
					break;
				}
			}
			if(check==null)bw.write("YES\n"); 
			else bw.write("NO\n");          
		}
		
		bw.close();
		br.close();
	}
}