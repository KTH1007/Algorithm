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
        long[][] dp = new long[n][3];
        // dp[0][0]에 사자가 있으면 dp[0][1]과 dp[1][0]은 안 됨
        //dp[n][0] -> 사자를 넣지 않은 경우
        //dp[n][1] -> 사자를 왼쪽 방에 넣은 경우
        //dp[n][2] -> 사자를 오른쪽 방에 넣은 경우
        dp[0][0] = 1;  //한마리도 배치하지 않는 경우
        dp[0][1] = 1;
        dp[0][2] = 1;
        for(int i=1; i<n; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }
        long sum = (dp[n-1][0] + dp[n-1][1] + dp[n-1][2]) % 9901;
        System.out.println(sum);
    }
}