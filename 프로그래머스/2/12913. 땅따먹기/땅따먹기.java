import java.util.*;
class Solution {
    static int max = Integer.MIN_VALUE;
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][land[0].length];
        
        for (int i = 0 ; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for (int i = 1; i < land.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 1][2], dp[i - 1][3])) + land[i][0];
            dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][2], dp[i - 1][3])) + land[i][1];
            dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3])) + land[i][2];
            dp[i][3] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])) + land[i][3];
        }
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[land.length - 1][i]);
        }
        return answer;
    }
}