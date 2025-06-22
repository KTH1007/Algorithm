import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<String> list = new ArrayList<>();
    static char[] arr;
    static int l, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new char[c];
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        dfs(0, new ArrayList<>());
        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int depth, List<Character> selected) {
        if (selected.size() == l) {
            String temp = "";
            int consonant = 0;
            int vowel = 0;
            for (Character character : selected) {
                temp += character;
                if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
                    vowel++;
                } else {
                    consonant++;
                }
            }
            if (consonant >= 2 && vowel >= 1) {
                list.add(temp);
            }
            return;
        }
        if (selected.size() + arr.length - depth < l) return;
        selected.add(arr[depth]);
        dfs(depth + 1, selected);
        selected.remove(selected.size() - 1);
        dfs(depth + 1, selected);
    }
}
