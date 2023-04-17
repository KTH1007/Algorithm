import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[101];
            dp[1] = dp[2] = dp[3] = 1;
            dp[4] = dp[5] = 2;
            for(int j=6; j<=n; j++){
                dp[j] = dp[j-2] + dp[j-3];
            }
            System.out.println(dp[n]);
        }

    }
}