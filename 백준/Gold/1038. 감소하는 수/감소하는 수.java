import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Long> list = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n > 1022) System.out.println(-1);
        else if (n <= 10) System.out.println(n);
        else {
            for (int i = 0; i < 10; i++) {
                dfs(0, i);
            }
            Collections.sort(list);
            System.out.println(list.get(n));
        }
    }

    static void dfs(int depth, long num) {
        if (depth > 9) return;
        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            dfs(depth + 1, num * 10 + i);
        }
    }

}
