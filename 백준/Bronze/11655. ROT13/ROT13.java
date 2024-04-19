import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {

                int c = s.charAt(i) + 13;
                if (c > 'Z') {
                    sb.append((char) (c % (int) 'Z' + 'A' - 1));
                } else sb.append((char) c);

            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {

                int c = s.charAt(i) + 13;
                if (c > 'z') {
                    sb.append((char) (c % (int) 'z' + 'a' - 1));
                } else sb.append((char) c);

            } else sb.append(s.charAt(i));
        }

        System.out.println(sb);

    }
}
