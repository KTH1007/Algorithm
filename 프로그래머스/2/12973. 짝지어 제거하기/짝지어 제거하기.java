import java.util.*;

class Solution
{
    public int solution(String s)
    {

        if (remove(s).length() == 0) {
            return 1;
        }
        
        return 0;
    }
    
    private String remove(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}