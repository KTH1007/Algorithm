import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static List<Integer> list = new ArrayList<>();
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list, Collections.reverseOrder());

        recursion(0);
        System.out.println(result);
        br.close();
    }
    private static void recursion(int current) {
        if (current > n) return;
        result = Math.max(result, current);

        for (int i = 0; i < k; i++) {
            recursion(current * 10 + list.get(i));
        }
    }

}
