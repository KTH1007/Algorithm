import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String temp = s.replace("0", "");
        String temp2 = s.replace("00", "!");
        if (s.length() == 0 ||temp.equals("") || s.charAt(0) == '0' || temp2.contains("!")) {
            System.out.println(0);
            return;
        }


        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        char pre = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            int current = s.charAt(i);
            if (current == '0') {
                if (pre == '1' || pre == '2') {
                    dp[i + 1] = dp[i - 1];
                }
            } else {
                if (pre == '1' || (pre == '2' && current <= '6')) {
                    dp[i + 1] = (dp[i] + dp[i - 1]) % 1000000;
                } else {
                    dp[i + 1] = dp[i];
                }
            }

            pre = s.charAt(i);
        }

        System.out.println(dp[s.length()]);
    }
}
