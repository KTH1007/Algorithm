import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = 0;
    static int[] arr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, -1);
        System.out.println(max);
    }

    private static void dfs(int depth, int sum, int pos) {
        if (depth == m) {
            max = Math.max(max, sum);
            return;
        }

        if (pos + 1 < n) {
            dfs(depth + 1, sum + arr[pos + 1], pos + 1);
        } else {
            dfs(depth + 1, sum, pos + 1);
        }
        if (pos + 2 < n) {
            dfs(depth + 1, sum / 2 + arr[pos + 2], pos + 2);
        } else {
            dfs(depth + 1, sum, pos + 2);
        }
    }
}
