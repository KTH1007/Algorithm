import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        
        int t = elements.length;
        int start = 1;
        
        while (start <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = i; j < start + i; j++) {
                    sum += elements[j % elements.length];
                }
                set.add(sum);
            }
            start++;
        }
        
        answer = set.size();
        return answer;
    }
}