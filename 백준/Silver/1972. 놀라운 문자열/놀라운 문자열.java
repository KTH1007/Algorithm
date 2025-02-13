import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("*")) break;

            boolean surprising = true;

            int num = s.length();

            for (int i = 1; i < num - 1; i++) {
                Set<String> set = new HashSet<>();
                if (!surprising) break;
                for (int j = 0; j < s.length(); j++) {
                    if (j + i + 1 > s.length()) break;
                    String temp = Character.toString(s.charAt(j)) + Character.toString(s.charAt(j + i));

                    if (set.contains(temp)) {
                        surprising = false;
                        break;
                    }

                    set.add(temp);
                }
            }

            if (surprising) {
                sb.append(s).append(" is surprising.").append("\n");
            } else {
                sb.append(s).append(" is NOT surprising.").append("\n");
            }
        }

        System.out.println(sb);
    }

}
