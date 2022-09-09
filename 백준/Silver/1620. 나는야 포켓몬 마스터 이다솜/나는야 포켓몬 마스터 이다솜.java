import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<Integer, String> map_int = new HashMap<Integer, String>();
		HashMap<String, Integer> map_str = new HashMap<String, Integer>();
		for (int i = 1; i <= n; i++) {
			String s = sc.next();
			map_str.put(s, i);
			map_int.put(i, s);
		}
		IsDigit isdigit = new IsDigit();
		for (int i = 1; i <= m; i++) {
			String tmp = sc.next();
			if(isdigit.IsNum(tmp)) {
				System.out.println(map_int.get(Integer.parseInt(tmp)));
			}
			else {
				System.out.println(map_str.get(tmp));
			}
		}
		sc.close();
	}
}

class IsDigit{
	public boolean IsNum(String tmp){
		for(int j=0; j<tmp.length(); j++) {
    		if(Character.isDigit(tmp.charAt(j)) == true) {
        		return true;
        	}
    	}
		return false;
	}
}
