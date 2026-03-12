import java.util.*;

class Solution {
    static int count = 0;
    
    public int solution(int n) {
        if (n <= 2) {
            return 1;
        }
        
        return twoPointer(n);
    }
    
    private static int twoPointer(int n) {
        int count = 0;
        
        int left = 1;
        int right = 2;
        int sum = left + right;
        
        while (left <= right) {
            if (sum == n) {
                count++;
                sum -= left;
                left++;
            } else if (sum > n) {
                sum -= left;
                left++;
            } else if (sum < n) {
                right++;
                sum += right;
            }
        }
        
        return count;
    }
}