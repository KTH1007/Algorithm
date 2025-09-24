import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t,i;
		t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String str = br.readLine().toLowerCase();
			boolean[] chk = new boolean[26];
			for(i=0;i<str.length();i++) if(str.charAt(i)>='a'&&str.charAt(i)<='z') chk[str.charAt(i)-'a'] = true;
			boolean ispan = true;
			for(i=0;i<26;i++) if(!chk[i]) ispan = false;
			if(ispan) {
				sb.append("pangram\n");
			}else {
				sb.append("missing ");
				for(i=0;i<26;i++) if(!chk[i]) sb.append((char)(i+'a'));
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}