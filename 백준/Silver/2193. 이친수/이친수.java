import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        long[] dp = new long[100];
        dp[1] = 1; //1
        dp[2] = 1; //10
        dp[3] = 2; //100, 101
        dp[4] = 3; //1010, 1001, 1000
        dp[5] = 5; //10000, 10001, 10100, 10101, 10010
        for(int i=6; i<=n; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        System.out.println(dp[n]);
    }
}
