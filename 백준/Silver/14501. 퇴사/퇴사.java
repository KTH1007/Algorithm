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
        int[] t = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            if(i+t[i] < n+1){   //퇴사 날짜를 넘어가지 않는 경우만 계산
                dp[i+t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            //해당 날짜에 일을 못하는 경우 이전까지 일한 최대 수당을 넣어줘야 함
            dp[i+1] = Math.max(dp[i+1],dp[i]);
        }
        System.out.println(dp[n]);
    }
}


