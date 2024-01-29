import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[100001];
        dp[n] = 1;
        bfs();
        System.out.println(dp[k] - 1);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 1});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int distance = current[1];
            if (x == k) return;

            if (x * 2 < 100001 && dp[x * 2] == 0) {
                queue.add(new int[]{x * 2, distance});
                dp[x * 2] = distance;
            }
            if (x - 1 >= 0 && dp[x - 1] == 0) {
                queue.add(new int[]{x - 1, distance + 1});
                dp[x - 1] = distance + 1;
            }
            if (x + 1 < 100001 && dp[x + 1] == 0) {
                queue.add(new int[]{x + 1, distance + 1});
                dp[x + 1] = distance + 1;
            }

        }
    }

}
