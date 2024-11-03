import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        List<Integer> S = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            S.add(Integer.parseInt(st.nextToken()));
        }

        int n = Integer.parseInt(br.readLine());

        if (S.contains(n)) {
            System.out.println(0);
            return;
        }

        int min = 0;
        int max = 1001;

        Collections.sort(S);
        for (int i = 0; i < L; i++) {
            if (S.get(i) < n) {
                min = Math.max(min, S.get(i));
            } else if (S.get(i) > n) {
                max = Math.min(max, S.get(i));
                break;
            }
        }

        int count = 0;
        for (int i = min + 1; i <= n; i++) {
            for (int j = n; j <= max - 1; j++) {
                if (i == j) continue;
                count++;
            }
        }
        System.out.println(count);
    }

}
