import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        int count = 0;
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                count += set.size();
                set = new HashSet<>();
            } else {
                set.add(s);
            }
        }

        count += set.size();
        System.out.println(count);
    }
}
