import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int min = Math.min(Math.min(b, c), d);

        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        List<Integer> D = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        func(B, b, st);
        st = new StringTokenizer(br.readLine());
        func(C, c, st);
        st = new StringTokenizer(br.readLine());
        func(D, d, st);

        int result = 0;
        for (int i = 0; i < min; i++) {
            result += (int) ((B.get(i) + C.get(i) + D.get(i)) * 0.1);
        }

        System.out.println(sum);
        System.out.println(sum - result);
    }

    private static void func(List<Integer> list, int size, StringTokenizer st) {
        for (int i = 0; i < size; i++) {
            int n = Integer.parseInt(st.nextToken());
            list.add(n);
            sum += n;
        }
        Collections.sort(list, Collections.reverseOrder());
    }

}
