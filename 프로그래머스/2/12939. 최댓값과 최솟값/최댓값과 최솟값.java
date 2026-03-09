import java.util.*;

class Solution {
    public String solution(String s) {
        String[] tokens = s.split(" ");
        int[] arr = new int[tokens.length];
        
        for(int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        
        Arrays.sort(arr);

        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ").append(arr[arr.length - 1]);
        answer = sb.toString();
        return answer;
    }
}