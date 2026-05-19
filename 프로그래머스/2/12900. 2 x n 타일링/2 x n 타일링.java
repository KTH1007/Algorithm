import java.util.*;

// 1 -> 1
// 2 -> 2
// 3 -> 3
// 4 -> 5
// 5 -> 8
// 6 -> 13

// 짝수일 때는 가로 세로 막대기 짝수개 or 둘 다 홀수
// 홀수일 때는 한쪽 홀수 한쪽 짝수개

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[60001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        dp[5] = 8;
        dp[6] = 13;
        
        for (int i = 7; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_007;
        }
        
        return dp[n];
    }
}