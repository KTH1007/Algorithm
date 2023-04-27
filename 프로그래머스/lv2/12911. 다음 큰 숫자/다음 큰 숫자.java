import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toString(n,2);
        s = s.replace("0", "");
        int count = s.length();
        int i = 0;
        while(true){
            i++;
            int n2 = n + i;
            String s2 = Integer.toString(n2,2);
            s2 = s2.replace("0","");
            int count2 = s2.length();
            if(count == count2){
                answer = n2;
                break;
            }
        }
        return answer;
    }
}