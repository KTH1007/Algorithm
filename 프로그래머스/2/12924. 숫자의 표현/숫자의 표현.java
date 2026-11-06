import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int n) {
        for (int i = 1; i <= n; i++) {
            sum(i, n);
        }
        return answer;
    }
    
    private static void sum(int start, int n) {
        int num = 0;
        while (num < n) {
            num += start;
            start++;
        }
        
        if (num == n) answer++;
    }
}