import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        /*
        1행 1열 1 1행 2열 2 1행 3열 3   행과 열중에 큰값으로
        2행 1열 2, 2행 2열 2, 2행 3열 3 행과 열중에 큰값으로
        이걸 하나로 묶으려면
        1행 1열부터 ~ n열까지,
        2행 1열 ~ n열까지 최대값으로
        n행 1열부터 ~ n열까지
        */
        
        int size = (int) right - (int) left + 1;

        int[] answer = new int[size];
        
        // 행 i / n + 1, 열 i % n + 1
        int count = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n + 1;
            long col = i % n + 1;
            
            answer[count++] = Math.max((int) row, (int) col);
        }
        
        
        return answer;
    }
}