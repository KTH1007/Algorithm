import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s.length() == 1) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String a = s.substring(0, i);
            String b = s.substring(i);

            int aMul = 1;
            int bMul = 1;

            for (int j = 0; j < a.length(); j++) {
                aMul *= (a.charAt(j) - '0');
            }

            for (int j = 0; j < b.length(); j++) {
                bMul *= (b.charAt(j) - '0');
            }

            if (aMul == bMul) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");


    }
}
