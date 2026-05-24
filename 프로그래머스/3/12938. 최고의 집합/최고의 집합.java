import java.util.*;

// n개로 합이 s가 되는 집합 같은 수 허용
// 최대한 균등하게 나누는게 최대값
// s / n 


class Solution {
    
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if (n > s) {
            return new int[]{-1};
        }
        
        int num = s / n;
        for (int i = 0; i < n; i++) {
            answer[i] = num;
        }
        
        if (s % n != 0) {
            int remainder = s % n;
            
            for (int i = 0; i < remainder; i++) {
                answer[i]++;
            }
            
            Arrays.sort(answer);
        }
        
        
        return answer;
    }
    
}