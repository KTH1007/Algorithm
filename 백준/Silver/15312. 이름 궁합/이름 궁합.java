import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] alpha = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[] dp = new int[s1.length() + s2.length()];

        for (int i = 0; i < s1.length() + s2.length() - 1; i += 2) {
            dp[i] = alpha[s1.charAt(i / 2) - 'A'];
            dp[i + 1] = alpha[s2.charAt(i / 2) - 'A'];
        }

        int size = dp.length;

        while (size > 2) {
            for (int i = 0; i < size - 1; i++) {
                dp[i] = (dp[i] + dp[i + 1]) % 10;
            }
            size--;
        }

        System.out.println(dp[0] + "" + dp[1]);
    }

}
