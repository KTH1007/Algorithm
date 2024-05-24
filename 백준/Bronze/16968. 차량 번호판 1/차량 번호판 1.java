import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int result;
        char before;
        if (s.charAt(0) == 'c') {
            before = 'c';
            result = 26;
        } else {
            before = 'd';
            result = 10;
        }


        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'c' && before == 'c') {
                result = result * 25;
            } else if (c == 'd' && before == 'd') {
                result = result * 9;
            } else if (c == 'c') {
                result *= 26;
                before = 'c';
            } else if (c == 'd') {
                result *= 10;
                before = 'd';
            }
        }

        System.out.println(result);
    }
}
