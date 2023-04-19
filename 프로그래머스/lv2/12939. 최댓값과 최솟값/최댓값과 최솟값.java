import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] st = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<st.length; i++){
            min = Math.min(min, Integer.parseInt(st[i]));
            max = Math.max(max, Integer.parseInt(st[i]));
        }
        answer = min + " " + max;
        return answer;
    }
}