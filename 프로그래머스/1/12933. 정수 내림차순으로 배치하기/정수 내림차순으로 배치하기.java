import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = Long.toString(n);
        
        int[] numbers = new int[10];
        
        for (int i = 0; i < s.length(); i++) {
            numbers[s.charAt(i) - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int count = numbers[i];
            String num = Integer.toString(i);
            sb.append(num.repeat(count));
        }
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}