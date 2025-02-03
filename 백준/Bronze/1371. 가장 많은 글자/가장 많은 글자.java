import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphabet = new int[26];
        int max = 0;
        String s;
        while ((s = br.readLine()) != null) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') continue;
                alphabet[c - 'a']++;
                max = Math.max(max, alphabet[c - 'a']);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] == max) {
                sb.append((char) (i + 97));
            }
        }

        System.out.println(sb);
    }
}
