import java.util.*;
class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        String answer = "";

        //1단계
        String s = new_id.toLowerCase();

        //2단계
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if((c>='a'&& c<='z') || (c == '-' || c=='_' || c=='.') || (c>='0' && c<='9'))
                sb.append(c);
        }

        //3단계
        String s2 = sb.toString().replace("..", ".");
        while(s2.contains(".."))
            s2 = s2.replace("..",".");


        //4단계
        if(s2.length() > 0){
            if(s2.charAt(0) == '.')
                s2 = s2.substring(1);
        }
        if(s2.length() > 0){
            if(s2.charAt(s2.length()-1) == '.')
                s2 = s2.substring(0,s2.length()-1);
        }

        //5단계
        if(s2.length() == 0)
            s2 = "a";

        //6단계
        if(s2.length() >= 16){
            s2 = s2.substring(0, 15);
            if(s2.charAt(s2.length()-1)=='.'){
                s2 = s2.substring(0,s2.length()-1);
            }
        }

        //7단계
        if(s2.length() <= 2){
            while(s2.length() <= 2){
                s2 += Character.toString(s2.charAt(s2.length() - 1));
            }
        }
        answer = s2;
        return answer;
    }
}




