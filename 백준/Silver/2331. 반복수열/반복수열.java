import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        int P = Integer.parseInt(st.nextToken());
        map.put(Integer.parseInt(A), 1);

        int num;
        while (true) {
            num = 0;
            for (int i = 0; i < A.length(); i++) {
                num += (int) Math.pow((A.charAt(i) - '0'), P);
            }
            if (map.containsKey(num) && map.get(num) > 1) {
                break;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
                A = Integer.toString(num);
            }
        }

        int count = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) count++;
        }

        System.out.println(count);
    }
}
