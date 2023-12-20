import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n;
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 각 자리 마다 선택하거나 선택하지 않거나 하는 경우 2^10 = 1024
        // 아무것도 선택하지 않는 경우 1을 빼면 1023가지 경우가 존재
        if (n <= 10) {
            System.out.println(n);
            return;
        } else if (n >= 1023) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            dfs(i, 0);
        }

        Collections.sort(list);
        System.out.println(list.get(n));

    }

    static void dfs(long num, int depth) {
        if (depth > 10) return;
        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            dfs((num * 10) + i, depth + 1);
        }
    }

}


