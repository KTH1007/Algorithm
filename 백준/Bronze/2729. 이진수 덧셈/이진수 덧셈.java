import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            BigInteger a = new BigInteger(s1, 2);
            BigInteger b = new BigInteger(s2, 2);

            BigInteger temp = a.add(b);
            sb.append(temp.toString(2)).append("\n");
        }

        System.out.println(sb);
    }

}
