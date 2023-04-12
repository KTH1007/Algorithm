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
        Long[] dp = new Long[n];
        if(n > 0){
            dp[0] = Long.valueOf(1);
        }
        if(n> 1){
            dp[0] = Long.valueOf(1);
            dp[1] = Long.valueOf(1);
        }
        if(n>2){
            dp[0] = Long.valueOf(1);
            dp[1] = Long.valueOf(1);
            dp[2] = Long.valueOf(1);
        }

        for(int i=3; i<n; i++){
            dp[i] = dp[i-1] + dp[i-3];
        }
        System.out.println(dp[n-1]);
    }
}
