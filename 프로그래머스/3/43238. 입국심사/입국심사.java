import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long left = 1;
        long right = times[0] * (long) n; // 제일 긴 시간 * 사람 수
        
        for (int time : times) {
            right = Math.max(right, time);
        }
        
        answer = binarySearch(left, right, n, times);
        return answer;
    }
    
    // 이분탐색
    private static long binarySearch(long left, long right, int n, int[] times) {
        long mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            
            // 입국 심사 통과한 사람
            long people = 0;
            
            for (int time : times) {
                people += mid / time;
            }
            
            // 시간 부족 (ex 20 -> 2 + 2 4명)
            if (people < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return right;
    }
}