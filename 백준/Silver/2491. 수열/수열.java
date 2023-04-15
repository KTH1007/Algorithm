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
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = 1;
        }
        int max = 1;
        for(int i=1; i<n; i++){
            if(arr[i] >= arr[i-1]){
                dp[i] = dp[i-1] + 1;
                max = Math.max(max, dp[i]);
            }
        }

        dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = 1;
        }
        int max2 = 1;
        for(int i=1; i<n; i++){
            if(arr[i] <= arr[i-1]){
                dp[i] = dp[i-1] + 1;
                max2 = Math.max(max2, dp[i]);
            }
        }

        System.out.println(Math.max(max,max2));
    }
}