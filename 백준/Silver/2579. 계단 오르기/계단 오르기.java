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
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n+1];
        dp[1] = arr[1]; //첫 번째 칸만 밟은 경우
        if(n >= 2){
            //첫 번째 칸과 두 번째 칸을 밟은 경우
            dp[2] = arr[1] + arr[2];
        }
        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3]+arr[i-1]) + arr[i];
        }
        System.out.println(dp[n]);
    }

}