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
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
            dp[i] = a;
        }
        int max = arr[0];
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+arr[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}

