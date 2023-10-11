import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("#")) break;
            list.add(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > 17 || b >= 80) map.put(s, "Senior");
            else map.put(s, "Junior");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " " + map.get(list.get(i)));
        }
    }


}




