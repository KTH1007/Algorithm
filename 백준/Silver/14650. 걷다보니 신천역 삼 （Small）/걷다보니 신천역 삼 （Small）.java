import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[10];
        dp[1] = 0;
        dp[2] = 2; //12 21
        dp[3] = 6; //102 112 121 201 210 222
        dp[4] = 18; //1002 1011 1020 1101 1110 1122 1200 1212 1221  2001 2010 2022 2100 2112 2121 2202 2211 2220
        for (int i = 5; i <= n; i++) {
            dp[i] = dp[i - 1] * 3;
        }
        System.out.println(dp[n]);


    }


}