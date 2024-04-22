import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        if (s.length() % 3 == 1) sb.append(s.charAt(0));
        if (s.length() % 3 == 2) sb.append((s.charAt(0) - '0') * 2 + (s.charAt(1) - '0'));

        for (int i = s.length() % 3; i < s.length(); i += 3) {
            sb.append((s.charAt(i) - '0') * 4 + (s.charAt(i + 1) - '0') * 2 + (s.charAt(i + 2) - '0'));
        }

        System.out.println(sb);


    }
}
