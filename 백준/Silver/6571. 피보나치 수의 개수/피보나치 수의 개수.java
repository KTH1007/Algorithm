import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            if (s1.equals("0") && s2.equals("0")) break;

            BigInteger a = new BigInteger(s1);
            BigInteger b = new BigInteger(s2);

            BigInteger f1 = BigInteger.ONE;
            BigInteger f2 = BigInteger.TWO;
            BigInteger f3;

            int count = 0;
            while (f1.compareTo(b) <= 0) {
                if (f1.compareTo(a) >= 0) count++;
                f3 = f1.add(f2);
                f1 = f2;
                f2 = f3;
            }

            sb.append(count).append("\n");

        }
        System.out.println(sb);
    }

}
