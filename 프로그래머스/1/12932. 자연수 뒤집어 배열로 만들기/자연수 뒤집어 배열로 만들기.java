import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        
        String s = Long.toString(n);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String reverseStr = sb.toString();
        int[] answer = new int[reverseStr.length()];
        for (int i = 0; i < s.length(); i++) {
            answer[i] = reverseStr.charAt(i) - '0';
        }
        return answer;
    }
}