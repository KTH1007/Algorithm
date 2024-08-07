import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> set = new HashSet<>();
        Set<String> check = new HashSet<>();

        int player;
        if (game.equals("Y")) {
            player = 1;
        } else if (game.equals("F")) {
            player = 2;
        } else {
            player = 3;
        }
        int count = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int before = check.size();
            check.add(s);
            if (before < check.size()) {
                set.add(s);
            }
            if (set.size() == player) {
                set.clear();
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }
}
