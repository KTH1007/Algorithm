import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        list.add("Never gonna give you up");
        list.add("Never gonna let you down");
        list.add("Never gonna run around and desert you");
        list.add("Never gonna make you cry");
        list.add("Never gonna say goodbye");
        list.add("Never gonna tell a lie and hurt you");
        list.add("Never gonna stop");

        int n = Integer.parseInt(br.readLine());
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (!list.contains(s)) flag = false;
        }
        if (flag) System.out.println("No");
        else System.out.println("Yes");
    }

}
