import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] tokens = s.split(" ");
        int[] arr = new int[tokens.length];
        
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        
        Arrays.sort(arr);
        answer = arr[0] + " " + arr[arr.length - 1];
    
        return answer;
    }
}