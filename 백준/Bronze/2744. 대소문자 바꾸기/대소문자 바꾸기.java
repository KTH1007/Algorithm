import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        String upper = s.toUpperCase();
        String lower = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') sb.append(lower.charAt(i));
            else sb.append(upper.charAt(i));
        }

        System.out.println(sb);
    }
}
