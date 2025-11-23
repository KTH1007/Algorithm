import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            dfs(1, n, 1, 0, 1, "1");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int depth, int n, int num, int sum, int op, String express) {
        if (depth == n) {
            sum += (num * op);
            if (sum == 0) {
                sb.append(express).append("\n");
            }
            return;
        }

        dfs(depth + 1, n, num * 10 + (depth + 1), sum, op, express + " " + (depth + 1));
        dfs(depth + 1, n, depth + 1, sum + (num * op), 1, express + "+" + (depth + 1));
        dfs(depth + 1, n, depth + 1, sum + (num * op), -1, express + "-" + (depth + 1));
    }
}
