import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<Integer> set = new HashSet<>();
    static int[] s;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, new ArrayList<>());
        int min = Integer.MAX_VALUE;

        List<Integer> answer = new ArrayList<>(set);
        answer.sort(null);

        for (int i = 0; i < answer.size() - 1; i++) {
            if (answer.get(i) + 1 < answer.get(i + 1)) {
                min = answer.get(i) + 1;
                break;
            }
        }

        if (min == Integer.MAX_VALUE) {
            min = answer.get(answer.size() - 1) + 1;
        }

        System.out.println(min);
    }

    private static void dfs(int depth, List<Integer> selected) {
        if (depth == n) {
            int sum = 0;
            for (Integer i : selected) {
                sum += i;
            }
            set.add(sum);
            return;
        }

        selected.add(s[depth]);
        dfs(depth + 1, selected);

        selected.remove(selected.size() - 1);
        dfs(depth + 1, selected);
    }
}
