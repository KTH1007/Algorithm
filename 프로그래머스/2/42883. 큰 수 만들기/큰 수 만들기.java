import java.util.*;

// 이미 있는 수 순서는 지켜야 됨

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : number.toCharArray()) {
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < c) {
                k--;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
        }
        
        answer = sb.substring(0, sb.length() - k);
        return answer;
    }
}