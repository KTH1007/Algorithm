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
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;  //2*2 1*2,  1*2 1*2 1*2, 2*1 2*1 1*2, 1*2 2*2, 1*2 2*1 2*1
        for(int i=4; i<=n; i++){
            dp[i] = (dp[i-2] * 2 + dp[i-1]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
