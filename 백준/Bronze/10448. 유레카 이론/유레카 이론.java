import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // 44+(44 + 1) / 2 = 990  45는 1000을 넘어감
        // 3가지 값을 합쳐야 하는데 최대는 44번째 값이기 때문에 시간복잡도는 O(44^3)

        StringBuilder sb = new StringBuilder();
        int[] dp = new int[45];
        dp[1] = 1;

        for (int i = 2; i < 45; i++) {
            dp[i] = i * (i + 1) / 2;
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (possible(n, dp)) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }

    static boolean possible(int n, int[] dp) {
        for (int i = 1; i < 45; i++) {
            for (int j = 1; j < 45; j++) {
                for (int k = 1; k < 45; k++) {
                    if (dp[i] + dp[j] + dp[k] == n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
