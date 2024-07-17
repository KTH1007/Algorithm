import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<String> list = new ArrayList<>();

        for (int i = 1; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                sub(list, s, i, j);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
        br.close();
    }

    private static void sub(List<String> list, String s, int i, int j) {
        StringBuilder sb1 = new StringBuilder(s.substring(0, i)).reverse();
        StringBuilder sb2 = new StringBuilder(s.substring(i, j)).reverse();
        StringBuilder sb3 = new StringBuilder(s.substring(j)).reverse();
        list.add(sb1.toString() + sb2.toString() + sb3.toString());
    }
}
