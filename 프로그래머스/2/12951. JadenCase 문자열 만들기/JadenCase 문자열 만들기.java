import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        boolean upper = true;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (isChar(current)) {
                if (upper) {
                    sb.append(Character.toUpperCase(current));
                } else {
                    sb.append(Character.toLowerCase(current));
                }
            } else {
                sb.append(current);
            }
            
            if (current == ' ') upper = true;
            else upper = false;
        }
        
        answer = sb.toString();
        return answer;
    }
    
    private static boolean isChar(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) return true;
        return false;
    }
}