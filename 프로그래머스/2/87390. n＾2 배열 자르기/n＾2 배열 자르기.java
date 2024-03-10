import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        int index = 0;
        
        // row col 중 max값 ex) (3, 1) -> 3 (1, 2) -> 2
        
        for (long i = left; i <= right; i++) {
            long row = i / n + 1;
            long col = i % n + 1;
            answer[index++] = (int) Math.max(row, col);
        }
        return answer;
    }
}