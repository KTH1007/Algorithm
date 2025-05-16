import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        int[] g = new int[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < k; i++) {
            g[i] = Integer.parseInt(st.nextToken());
            sum += g[i];
        }

        result = new boolean[sum + 1];

        dfs(0, k, 0, g, sum);
        int answer = 0;
        for (int i = 0; i < result.length; i++) {
            if (!result[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int depth, int k, int num, int[] g, int sum) {
        if (depth == k) {
            if (num >= 0 && num <= sum && !result[num]) {
                result[num] = true;
            }
            return;
        }

        dfs(depth + 1, k, num, g, sum);
        dfs(depth + 1,k, num + g[depth], g, sum);
        dfs(depth + 1, k, num - g[depth] , g, sum);
    }

}
