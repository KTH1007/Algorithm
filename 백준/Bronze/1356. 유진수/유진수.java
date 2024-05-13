import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        if (s.length() == 1) {
            System.out.println("NO");
            return;
        }

        boolean flag = false;

        for (int i = 1; i < s.length(); i++) {
            String temp1 = s.substring(0, i);
            String temp2 = s.substring(i);

            int result1 = 1;
            int result2 = 1;

            for (int j = 0; j < temp1.length(); j++) {
                result1 *= temp1.charAt(j) - '0';
            }

            for (int j = 0; j < temp2.length(); j++) {
                result2 *= temp2.charAt(j) - '0';
            }

            if (result1 == result2) {
                flag = true;
            }
        }

        if (flag) System.out.println("YES");
        else System.out.println("NO");

    }

}
