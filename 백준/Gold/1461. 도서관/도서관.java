import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer> plus = new ArrayList<>();
    static List<Integer> minus = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (Math.abs(num) > max) max = Math.abs(num);
            if (num > 0) plus.add(num);
            else minus.add(Math.abs(num));
        }
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());

        for (int i = 0; i < plus.size(); i++) {
            if (plus.get(i) == max && i % m == 0) count += plus.get(i);
            else if (i % m == 0) count += (plus.get(i) * 2);
        }
        for (int i = 0; i < minus.size(); i++) {
            if (minus.get(i) == max && i % m == 0) count += minus.get(i);
            else if (i % m == 0) count += (minus.get(i) * 2);
        }
        System.out.println(count);

    }


}
