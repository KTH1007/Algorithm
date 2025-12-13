import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long remainder = n % 7;

        if (remainder == 0 || remainder == 2) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

//        boolean[] dp = new boolean[101];
//
//        dp[1] = true;
//        dp[2] = false;
//
//        for (int i = 3; i <= 100; i++) {
//            dp[i] = !dp[i - 1] || (i >= 3 && !dp[i - 3]) || (i >= 4 && !dp[i - 4]);
//        }
//
//        for (int i = 1; i <= 100; i++) {
//            System.out.println(i + " -> " + (dp[i] ? "SK" : "CY"));
//        }
    }
}
