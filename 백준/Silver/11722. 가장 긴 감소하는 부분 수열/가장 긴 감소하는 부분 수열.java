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
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        int count = 1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i] < arr[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            count = Math.max(count, dp[i]);
        }
        System.out.println(count);
    }
}
