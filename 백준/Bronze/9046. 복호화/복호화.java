import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int[] arr = new int[26];
            String s = br.readLine();
            s = s.replace(" ", "");

            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 'a']++;
            }

            int max = arr[0];
            char c = 'a';
            boolean duplicate = false;

            for (int i = 1; i < 26; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    c = (char) (i + 97);
                    duplicate = false;
                } else if (arr[i] == max) {
                    duplicate = true;
                }
            }

            if (duplicate) {
                sb.append("?").append("\n");
            } else {
                sb.append(c).append("\n");
            }
        }

        System.out.println(sb);
    }
}
