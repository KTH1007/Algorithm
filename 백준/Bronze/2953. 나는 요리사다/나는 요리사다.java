import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += Integer.parseInt(st.nextToken());
            }
            map.put(i, sum);
            max = Math.max(max, sum);
        }

        for (int i = 1; i <= 5; i++) {
            if (map.get(i) == max) {
                System.out.println(i + " " + max);
                break;
            }
        }
    }

}
