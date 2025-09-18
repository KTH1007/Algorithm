import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String s = br.readLine();
            if (checkStr(s)) {
                sb.append("OK").append("\n");
            } else {
                sb.append("FAKE").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean checkStr(String s) {
        int[] alpha = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alpha[c - 'A']++;
            if (alpha[c - 'A'] == 3) {
                if (i + 1 >= s.length()) {
                    return false;
                }
                if (s.charAt(i) != s.charAt(i + 1)) {
                    return false;
                }
                i++;
                alpha[c - 'A'] = 0;
            }
        }
        return true;
    }
}
