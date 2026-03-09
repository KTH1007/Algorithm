import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (count1 == 0 && arr[i] == ')') {
                return false;
            }
            
            if (arr[i] == '(') {
                count1++;
            } else if (arr[i] == ')') {                
                if (count1 > 0) {
                    count1--;
                } else {
                    count2++;
                }
            }
            
        }
        
        if (count1 != 0 || count2 != 0) {
            return false;
        }
        return answer;
    }
}