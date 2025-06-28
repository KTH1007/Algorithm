import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            dp[arr[i]] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        if (dp[k] == Integer.MAX_VALUE - 1) {
            dp[k] = -1;
        }
        System.out.println(dp[k]);
    }

}
