import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        
        int[] answer = new int[(int)(right - left) + 1];
        int idx = 0;
        //해당 인덱스가 배열의 값 ex) (4,1) -> 4  (1,3) -> 3
        for(long i=left; i<=right; i++){
            long row = i/n + 1;
            long col = i%n + 1;
            answer[idx++] = (int)Math.max(row,col);
        }
        return answer;
    }
}