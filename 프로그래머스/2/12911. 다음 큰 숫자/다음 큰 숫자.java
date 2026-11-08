import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = n + 1; i <= 1000000; i++) {
            if (checkCount(n, i)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    private static boolean checkCount(int a, int b) {
        String s1 = Integer.toString(a, 2);
        String s2 = Integer.toString(b, 2);
        
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '1') count1++;
        }
        
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == '1') count2++;
        }
        
        return (count2 == count1) && b > a;
    }
}