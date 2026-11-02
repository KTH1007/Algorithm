import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> queue = new ArrayDeque<>();
        Deque<Character> queue2 = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            queue.add(c);
        }
        
        char prev = queue.poll();
        if (prev == ')') return false;
        queue2.add(prev);
        
        while (!queue.isEmpty()) {
            prev = queue.poll();
            if (prev == ')') {
                if (!queue2.isEmpty() &&queue2.peekLast() == '(')
                    queue2.poll();
                else queue2.add(prev);
            } else {
                queue2.add(prev);
            }
        }

        if (!queue2.isEmpty()) answer = false;
        return answer;
    }
}