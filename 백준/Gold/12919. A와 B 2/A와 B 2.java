import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        ab(s, t);

        System.out.println(result);
    }

    static void ab(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) result = 1;
            return;
        }
        if (t.charAt(t.length() - 1) == 'A') {
            ab(s, t.substring(0, t.length() - 1));
        }
        if (t.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder();
            t = sb.append(t).reverse().toString();
            ab(s, t.substring(0, t.length() - 1));
        }

    }


}

