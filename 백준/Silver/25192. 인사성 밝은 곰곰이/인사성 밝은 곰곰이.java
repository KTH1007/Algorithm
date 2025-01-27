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
        while (n-- > 0) {
            String s = br.readLine();

            if (s.equals("ENTER")) {
                count += set.size();
                set = new HashSet<>();
                continue;
            }

            set.add(s);
        }

        System.out.println(count + set.size());
    }
}
