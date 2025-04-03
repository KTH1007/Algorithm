import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static char[] duck = {'q', 'u', 'a', 'c', 'k'};
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        visited = new boolean[s.length()];

        int answer = 0;
        if (s.charAt(0) != 'q' || s.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }

        int idx = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            List<Character> list = new ArrayList<>();

            for (int j = i; j < s.length(); j++) {
                if (!visited[j] && s.charAt(j) == duck[idx]) {
                    idx++;
                    list.add(s.charAt(j));
                    visited[j] = true;

                    if (idx == 5) {
                        idx = 0;
                    }
                }
            }

            if (!list.isEmpty()) {
                if (list.get(list.size() - 1) != 'k') {
                    System.out.println(-1);
                    return;
                }
                count++;
            }
        }

        System.out.println(count);
    }
}
