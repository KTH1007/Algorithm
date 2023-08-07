import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String s, t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        while (t.length() > s.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t = t.substring(0, t.length() - 1);
            } else if (t.charAt(t.length() - 1) == 'B') {
                t = t.substring(0, t.length() - 1);
                StringBuilder sb = new StringBuilder();
                sb.append(t).reverse();
                t = sb.toString();
            }
        }
        if (t.equals(s)) System.out.println(1);
        else System.out.println(0);
    }


}

