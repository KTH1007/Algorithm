import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		BigInteger[] a = new BigInteger[n+1];
		a[0] = BigInteger.ZERO;
		if(n>0) {
			a[1] = BigInteger.ONE;
		}
		if(n>1) {
			for(int i=2; i<=n; i++) {
				a[i] = a[i-2].add(a[i-1]);
			}
			System.out.println(a[n]);
		}
		else if(n == 0) {
			System.out.println(0);
		}
		else if(n == 1) {
			System.out.println(1);
		}
	}
}
