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
        int[] hp = new int[n];
        int[] joy = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            hp[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            joy[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[100];
        for(int i=0; i<n; i++){
            for(int j = 99; j>=hp[i]; j--){
                dp[j] = Math.max(dp[j - hp[i]]+joy[i],dp[j]);
            }
        }
        System.out.println(dp[99]);
    }
}
