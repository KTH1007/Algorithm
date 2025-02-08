import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int num = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, n, arr[0], k, arr);

        System.out.println(num);
    }

    private static void dfs(int depth, int n, int i, int k, int[] arr) {
        if (depth > n) {
            return;
        }
        if (i == k) {
            num = depth + 1;
            return;
        }

        dfs(depth + 1, n, arr[i], k, arr);
    }
}
