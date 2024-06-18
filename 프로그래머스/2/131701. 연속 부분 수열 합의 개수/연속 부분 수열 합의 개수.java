import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        int sum = 0;
        
        for (int len = 1; len <= elements.length; len++) {
            sum = 0;
            for (int i = 0; i < elements.length; i++) {
                sum += elements[(len + i - 1) % elements.length];
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }
}