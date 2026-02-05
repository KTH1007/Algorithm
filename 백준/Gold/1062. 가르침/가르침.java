import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, k;
    static String[] arr;
    static boolean[] alpha;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        k = Integer.parseInt(tokens[1]);

        arr = new String[n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String temp = s.substring(4, s.length() - 4);
            arr[i] = temp;
        }

        // a n t i c
        if (k < 5) {
            System.out.println(0);
            return;
        }

        k -= 5;
        alpha = new boolean[26];
        alpha['a' - 'a'] = true;
        alpha['n' - 'a'] = true;
        alpha['t' - 'a'] = true;
        alpha['i' - 'a'] = true;
        alpha['c' - 'a'] = true;

        dfs(0, 0);
        System.out.println(max);
    }

    private static void dfs(int depth, int at) {
        if (depth == k) {
            max = Math.max(max, wordCount());
            return;
        }

        if (at == 26) {
            return;
        }

        dfs(depth, at + 1);

        if (!alpha[at]) {
            alpha[at] = true;
            dfs(depth + 1, at + 1);
            alpha[at] = false;
        }
    }

    private static boolean wordCheck(String s) {
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (!alpha[c]) {
                return false;
            }
        }

        return true;
    }

    private static int wordCount() {
        int wordCount = 0;
        for (int i = 0; i < n; i++) {
            if (wordCheck(arr[i])) {
                wordCount++;
            }
        }

        return wordCount;
    }
}
