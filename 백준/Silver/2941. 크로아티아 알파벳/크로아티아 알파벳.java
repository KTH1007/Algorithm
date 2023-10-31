import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'c' && i + 1 < s.length()) {
                if (s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-') {
                    count++;
                    i++;
                    continue;
                }
            } else if (s.charAt(i) == 'd' && i + 1 < s.length()) {
                if (s.charAt(i + 1) == '-') {
                    count++;
                    i++;
                    continue;
                }
                if (s.charAt(i + 1) == 'z' && i + 2 < s.length()) {
                    if (s.charAt(i + 2) == '=') {
                        count++;
                        i += 2;
                        continue;
                    }
                }
            } else if ((s.charAt(i) == 'l' && i + 1 < s.length()) || (s.charAt(i) == 'n' && i + 1 < s.length())) {
                if (s.charAt(i + 1) == 'j') {
                    count++;
                    i++;
                    continue;
                }
            } else if ((s.charAt(i) == 's' && i + 1 < s.length()) || (s.charAt(i) == 'z' && i + 1 < s.length())) {
                if (s.charAt(i + 1) == '=') {
                    count++;
                    i++;
                    continue;
                }
            }
            count++;
        }
        System.out.println(count);
    }


}
