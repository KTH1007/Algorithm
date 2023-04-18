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
        long[] dp = new long[n+1];
        if(n >=1){
            dp[1] = 1; // 1
        }
        if(n >= 2 ){
            dp[1] = 1; // 1
            dp[2] = 2;  //00, 11
        }
        //dp[3] = 3;  //001, 100, 111
        //dp[4] = 5;  //0000, 0011, 1100, 1111, 1001
        //dp[5] = 8;  //00001,  00100, 10000, 11111, 11100, 00111, 11001, 10011
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }
        System.out.println(dp[n]);
    }
}