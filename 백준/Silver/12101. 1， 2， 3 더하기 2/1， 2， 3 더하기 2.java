import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] dp;
    static int count = 0;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[12];
        dfs(0, 0);

        if (!flag) System.out.println(-1);

    }

    static void dfs(int depth, int num) {
        if (num > n) return;
        if (num == n) {
            count++;
            if (count == k) {
                flag = true;
                for (int i = 0; i < depth - 1; i++) {
                    System.out.print(dp[i] + "+");
                }
                System.out.println(dp[depth - 1]);
            }
            return;
        }
        for (int i = 1; i < 4; i++) {
            dp[depth] = i;
            dfs(depth + 1, num + i);
        }
    }

}
