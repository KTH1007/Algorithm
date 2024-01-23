import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int a = 0;
        int b = 0;
        if (s.charAt(1) == '0') a = 10;
        else a = s.charAt(0) - '0';

        if (a == 10 && s.length() == 4) b = 10;
        else if (a == 10 && s.length() == 3) b = s.charAt(2) - '0';
        else if (a != 10 && s.length() == 2) b = s.charAt(1) - '0';
        else if (a != 10 && s.length() == 3) b = 10;

        System.out.println(a + b);
    }
}
