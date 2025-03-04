import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] arr;
    static int[] op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int depth, int num) {
        if (depth == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) continue;
            op[i]--;
            if (i == 0) dfs(depth + 1, num + arr[depth]);
            else if (i == 1) dfs(depth + 1, num - arr[depth]);
            else if (i == 2) dfs(depth + 1, num * arr[depth]);
            else dfs(depth + 1, num / arr[depth]);
            op[i]++;
        }
    }
}
