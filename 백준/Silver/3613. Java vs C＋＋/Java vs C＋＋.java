import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        if (!checkError(s)) {
            System.out.println("Error!");
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '_') {
                char temp = s.charAt(i + 1);
                if (i + 1 < s.length() && temp >= 'a' && temp <= 'z') {
                    sb.append(Character.toString(temp).toUpperCase());
                    i++;
                } else {
                    System.out.println("Error!");
                    return;
                }
            } else if (c >= 'A' && c <= 'Z'){
                if (i == 0) {
                    System.out.println("Error!");
                    return;
                }
                sb.append("_").append(Character.toString(c).toLowerCase());
            } else {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }

    private static boolean checkError(String s) {
        int countUnderbar = 0;
        int countUpper = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                return false;
            }
            if (s.charAt(0) == '_' || s.charAt(s.length() - 1) == '_') {
                return false;
            }
            if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
                return false;
            }
            if (c == '_'){
                if (i + 1 < s.length() && s.charAt(i + 1) == '_') {
                    return false;
                }
            }
            if (c == '_') {
                countUnderbar++;
                if (countUpper > 0) return false;
            }
            if (c >= 'A' && c <= 'Z') {
                countUpper++;
                if (countUnderbar > 0) return false;
            }
        }
        return true;
    }
}
