import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] alphabet = new char[27];
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alphabet[c - 'a']++;
        }

        dfs(0, s.length(), "");
        System.out.println(result);
    }

    private static void dfs(int index, int len, String temp) {
        if (index == len) {
            result++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] == 0) {
                continue;
            }
            if (temp != "" && temp.charAt(temp.length() - 1) == (char) ('a' + i)) {
                continue;
            }
            alphabet[i]--;
            dfs(index + 1, len, temp + (char) ('a' + i));
            alphabet[i]++;
        }
    }
}
