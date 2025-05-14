import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            String s = br.readLine();
            boolean isShortcutKey = false;

            String[] words = s.split(" ");

            for (int i = 0; i < words.length; i++) {
                String str = words[i].charAt(0) + "";
                int index = 0;

                if (!set.contains(str.toLowerCase()) && !set.contains(str.toUpperCase())) {
                    set.add(str.toUpperCase());
                    set.add(str.toLowerCase());
                    isShortcutKey = true;

                    for (int j = 0; j < i; j++) {
                        index += words[j].length();
                        if (index != 0) index += 1;
                    }

                    sb.append(s.substring(0, index)).append("[").append(s.charAt(index)).append("]").append(s.substring(index + 1)).append("\n");
                    break;
                }
            }

            if (isShortcutKey) continue;

            for (int i = 0; i < s.length(); i++) {
                String str = s.charAt(i) + "";

                if (!str.equals(" ") && !set.contains(str.toUpperCase()) && !set.contains(str.toLowerCase())) {
                    set.add(str.toUpperCase());
                    set.add(str.toLowerCase());
                    isShortcutKey = true;

                    sb.append(s.substring(0, i)).append("[").append(s.charAt(i)).append("]").append(s.substring(i + 1)).append("\n");
                    break;
                }
            }

            if (isShortcutKey) continue;

            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

}
