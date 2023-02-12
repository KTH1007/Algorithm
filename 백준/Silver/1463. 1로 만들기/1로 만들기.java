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
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 0;
        for(int i=2; i<=n; i++){
            //1씩 빼준 값을 dp에 저장한다.
            dp[i] = dp[i - 1] + 1;
            //1을 뺀 값과 2로 나눈 값 중에 최소값을 넣어준다.
            if(i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            //1을 뺀 값과 2로 나눈 값 중에 최소값, 3으로 나눈 최소값 중에서 최소값을 넣어준다.
            if(i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        System.out.println(dp[n]);
    }
}