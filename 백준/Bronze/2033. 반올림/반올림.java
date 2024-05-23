import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int temp = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            int n = s.charAt(i) - '0';
            if (i == 0) {
                if (temp != 0) {
                    String string = sb.reverse().toString();
                    sb.append(n + 1);
                    System.out.println(n + 1 + string);
                } else {
                    sb.append(n);
                    System.out.println(sb.reverse());
                }
                break;
            }
            if (temp == 10) {
                n++;
            }
            if (n >= 5) temp = 10;
            else temp = 0;
            sb.append(temp % 10);
        }

//        System.out.println(sb.reverse());

    }
}
