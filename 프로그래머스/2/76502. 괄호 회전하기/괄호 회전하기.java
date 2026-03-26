import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int len = s.length();
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            String temp = s.substring(1);
            sb.append(temp).append(s.charAt(0));
            s = sb.toString();
            
            if (isPossible(s)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static boolean isPossible(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}