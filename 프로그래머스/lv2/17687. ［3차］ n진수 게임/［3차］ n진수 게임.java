import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String s = "";
        List<String> list = new ArrayList<>();
        for(int i=0; i<t*m; i++){
            s += Integer.toString(i,n);
        }
        s = s.toUpperCase();
        int count = 0;
        s = s.substring(0,t*m);
        for(int i=0; i<s.length(); i++){
            if(count >= m)
                count = 0;
            count++;
            if(count == p){
                char c = s.charAt(i);
                list.add(Character.toString(c));
            }
        }
        for(int i=0; i<list.size(); i++){
            answer += list.get(i);
        }
        return answer;
    }
}