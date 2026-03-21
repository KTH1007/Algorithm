import java.util.*;

class Solution {
    public long solution(int n) {
        long answer = 0;
        
        int[] dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3; // 1 1 1, 1 2, 2 1
        dp[4] = 5;
        dp[5] = 8; // 11111, 1112, 1121, 1211, 2111, 221, 212, 122
        
        for (int i = 5; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }
        answer = dp[n];
        return answer;
    }
}