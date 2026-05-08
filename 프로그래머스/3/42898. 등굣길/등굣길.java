import java.util.*;


class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        Set<String> puddelSet = new HashSet<>();
        int[][] dp = new int[m][n];
        boolean[][] water = new boolean[m][n];
        for (int[] p : puddles) {
            water[p[0] - 1][p[1] - 1] = true;
        }
        
        dp[0][0] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                
                if (water[i][j]) {
                    continue;
                }
                
                // i - 1 과 j - 1을 더해줘야 함
                int up = 0;
                int right = 0;
                if (i > 0) {
                    up = dp[i - 1][j];
                }
                if (j > 0) {
                    right = dp[i][j - 1];
                }
                dp[i][j] = (up + right) % 1000000007;
            }
        }
        answer = dp[m - 1][n - 1];
        return answer;
    }
}