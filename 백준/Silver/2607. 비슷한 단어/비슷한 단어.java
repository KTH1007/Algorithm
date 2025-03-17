import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int result = 0;

        int t = Integer.parseInt(br.readLine()) - 1;
        String s = br.readLine();
        while (t-- > 0) {
            String str = br.readLine();
            int[] alpha = new int[26];

            for (int i = 0; i < s.length(); i++) {
                alpha[s.charAt(i) - 'A']++;
            }

            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                if (alpha[str.charAt(i) - 'A'] > 0) {
                    count++;
                    alpha[str.charAt(i) - 'A']--;
                }
            }

            if (s.length() == str.length() && (s.length() == count || s.length() - 1 == count)) {
                result++;
            } else if (s.length() + 1 == str.length() && s.length() == count) {
                result++;
            } else if (s.length() - 1 == str.length() && s.length() - 1 == count) {
                result++;
            }

        }

        System.out.println(result);
    }

}
