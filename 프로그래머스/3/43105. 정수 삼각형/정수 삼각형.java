import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        
        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            dp[triangle.length - 1][i] = triangle[triangle.length - 1][i];
        }
        
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }

        answer = dp[0][0];
        return answer;
    }
}