import java.util.*;

class Solution {
    static int count = 0;
    static int removeZeroCount = 0;
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        function(s);
        answer[0] = count;
        answer[1] = removeZeroCount;
        return answer;
    }
    
    private static void function(String s) {
        if (s.equals("1")) return;
        
        count++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') removeZeroCount++;
        }
        
        s = s.replaceAll("0", "");
        s =  Integer.toString(s.length(), 2);

        System.out.println(s);
        function(s);
    }
}