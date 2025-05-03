import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int[] nums;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (s == 0) answer--;
        System.out.println(answer);
    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) {
                answer++;
            }
            return;
        }

        dfs(depth + 1, sum + nums[depth]);
        dfs(depth + 1, sum);
    }
}
