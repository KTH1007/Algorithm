import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        StringBuilder s = new StringBuilder(a);
        StringBuilder t = new StringBuilder(b);

        while (s.toString().length() != t.toString().length()) {
            if (s.toString().length() > t.toString().length()) {
                t.append(b);
            } else s.append(a);
        }

        if (s.toString().equals(t.toString())) {
            System.out.println(1);
        } else System.out.println(0);
    }


}
