import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int k = s.length();
        while(k-- > 0){
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(!stack.isEmpty() && stack.peek() == '[' && c == ']')
                    stack.pop();
                else if(!stack.isEmpty() && stack.peek() == '{' && c == '}')
                    stack.pop();
                else if(!stack.isEmpty() && stack.peek() == '(' && c == ')')
                    stack.pop();
                else
                    stack.push(c);
            }
            if(stack.isEmpty())
                answer++;
            s = s.substring(1) + s.substring(0,1);
        }
        return answer;
    }
}