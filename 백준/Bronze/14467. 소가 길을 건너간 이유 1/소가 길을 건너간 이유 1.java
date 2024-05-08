import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!map.containsKey(a)) {
                map.put(a, b);
            } else {
                if (map.get(a) != b) {
                    count++;
                    map.put(a, b);
                }
            }
        }

        System.out.println(count);
    }

}
