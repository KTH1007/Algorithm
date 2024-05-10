import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();

        int temp = n % p;
        int count = 1;
        map.put(temp, 1);

        while (true) {
            temp = (temp * n) % p;
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            if (map.get(temp) == 3) break;
        }

        for (int i : map.keySet()) {
            if (map.get(i) == 2) count++;
        }

        System.out.println(count);


    }

}
