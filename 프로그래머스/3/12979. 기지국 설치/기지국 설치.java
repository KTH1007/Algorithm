import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int prev = 1;
        
        for (int station : stations) {
            if (prev < station - w) {
                int length = station - w - prev;
                answer += (length + (2 * w)) / (2 * w + 1);
            }
            prev = station + w + 1;
        }
        
        if (prev <= n) {
            int length = n - prev + 1;
            answer += (length + (2 * w)) / (2 * w + 1);
        }
        
        return answer;
    }
}