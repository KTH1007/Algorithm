import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int size = p.length();
        String[] arr = new String[t.length()-size+1];
        for(int i=0; i<t.length()-size+1; i++){
            arr[i] = t.substring(i,size+i);
        }
        long a = Long.parseLong(p);
        for(int i=0; i<arr.length; i++){
            if(a >= Long.parseLong(arr[i]))
                answer++;
        }
        return answer;
    }
}