import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] alpha = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'A']++;
        }

        char center = '0';
        int centerCount = 0;

        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 != 0) {
                center = (char) (i + 'A');
                centerCount++;
            }
        }

        if (centerCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < alpha.length; i++) {
            sb.append(Character.toString((char) (i + 65)).repeat(alpha[i] / 2));
        }

        String repeatStr = sb.reverse().toString();
        sb.reverse();

        if (centerCount == 1) sb.append(center);

        sb.append(repeatStr);

        System.out.println(sb);
    }
}
