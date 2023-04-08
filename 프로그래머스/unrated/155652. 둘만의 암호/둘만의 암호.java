import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        char[] arr = new char[skip.length()];
        for(int i=0; i<skip.length(); i++){
            arr[i] = skip.charAt(i);
        }
        Arrays.sort(arr);
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int count = 0;
            while(count < index){
                c++;              
                if(c > 'z')
                    c -= 26;
                if(skip.contains(Character.toString(c))){
                    continue;
                }
                else
                    count++;
            }
            sb.append(c);
        }
        answer = sb.toString();
        return answer;
    }
}