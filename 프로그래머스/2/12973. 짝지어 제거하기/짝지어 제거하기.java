import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        Deque<Character> deque = new ArrayDeque<>();
        
        deque.add(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!deque.isEmpty() && deque.getLast() == c) deque.pollLast();
            else deque.add(c);
        }
        
        if (deque.isEmpty()) answer = 1;

        return answer;
    }
}