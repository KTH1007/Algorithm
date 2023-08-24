import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] count = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    static String num = "";


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            list.add(c1);
            list.add(c2);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            int temp = (count[list.get(i) - 'A'] + count[list.get(i + 1) - 'A'] % 10);
            num += temp;
        }
        while (num.length() != 2) {
            String temp = "";
            for (int i = 0; i < num.length() - 1; i++) {
                int n = (num.charAt(i) - '0' + num.charAt(i + 1) - '0') % 10;
                temp += Integer.toString(n);
            }
            num = temp;
        }
        System.out.println(num);
    }


}