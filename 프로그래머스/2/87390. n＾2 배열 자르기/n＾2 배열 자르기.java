import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int index = 0;
        int[] answer = new int[(int) (right - left) + 1];
        for (long i = left; i <= right; i++) {
            long row = i / n + 1;
            long col = i % n + 1;
            
            answer[index++] = (int) (Math.max(row, col));
        }
        
        // n == 4 left = 2, right 5
        // row=2, col=1
        // 2, 4,
        
        // 1 2 3 4
        // 2 2 3 4
        // 3 3 3 4
        // 4 4 4 4
        
        // 1 2 3 4 2 2 3 4 3 3 3 4 4 4 4 4
        return answer;
    }
}