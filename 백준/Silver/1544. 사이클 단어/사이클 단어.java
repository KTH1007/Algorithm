import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        int count = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (!set.contains(s)) {
                count++;
                set.add(s);

                for (int j = 0; j < s.length(); j++) {
                    StringBuilder sb = new StringBuilder(s);
                    String subStr = sb.substring(0, j);
                    sb.delete(0, j);
                    sb.append(subStr);
                    set.add(sb.toString());
                }
            }
        }
        System.out.println(count);
    }

}
