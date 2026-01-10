import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int Bx = Integer.parseInt(st.nextToken());
		int By = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int Dx = Integer.parseInt(st.nextToken());
		int Dy = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int Jx = Integer.parseInt(st.nextToken());
		int Jy = Integer.parseInt(st.nextToken());

		int Bmove = Math.max((Math.abs(Bx - Jx)), (Math.abs(By - Jy)));
		int Dmove = Math.abs(Dx - Jx) + Math.abs(Dy - Jy);
		
		if(Bmove < Dmove) {
			System.out.println("bessie");
		}else if(Bmove > Dmove) {
			System.out.println("daisy");
		}else {
			System.out.println("tie");
		}
	}

}