import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;

            boolean flag = false;
            int consonant = 0;
            int vowel = 0;
            boolean max = false;
            boolean same = false;
            char temp = s.charAt(0);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    flag = true;
                    vowel++;
                    consonant = 0;
                    if (vowel >= 3) {
                        max = true;
                    }
                } else {
                    consonant++;
                    vowel = 0;
                    if (consonant >= 3) {
                        max = true;
                    }
                }

                if (i > 0 && temp == c) {
                    if (!(c == 'e' || c == 'o')) {
                        same = true;
                    }
                }
                temp = c;
            }
            if (flag && !max && !same) {
                sb.append("<").append(s).append(">").append(" is acceptable.").append("\n");
            } else
                sb.append("<").append(s).append(">").append(" is not acceptable.").append("\n");
        }
        System.out.println(sb);
        br.close();
    }

}
