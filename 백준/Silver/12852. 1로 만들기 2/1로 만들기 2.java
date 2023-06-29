import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n+1];
        int[] before = new int[n+1];
        dp[1] = 0;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + 1;
            before[i] = i-1;
            if(i % 3 == 0 && dp[i/3] + 1 < dp[i] ){
                dp[i] = dp[i/3] + 1;
                before[i] = i/3;
            }
            if(i % 2 == 0 && dp[i/2] + 1 <dp[i]){
                dp[i] = dp[i/2] + 1;
                before[i] = i/2;
            }
        }

        int m = n;
        String s = "";
        while (m > 0){
            s += m + " ";
            m = before[m];
        }
        System.out.println(dp[n]);
        System.out.println(s);
    }
}

