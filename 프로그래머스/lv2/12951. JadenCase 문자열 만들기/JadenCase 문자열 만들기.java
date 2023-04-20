import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        /*limit이 양수이면 split은 최대 limit개의 요소를 가진 배열을 반환합니다.
        limit이 0이면 split은 빈 문자열을 제거한 후 모든 결과를 반환합니다.
        limit이 음수이면 split은 빈 문자열도 포함하여 모든 결과를 반환합니다.
        */
        String[] st = s.split(" ", -1);
        for(int i=0; i<st.length; i++){
            if(!st[i].isEmpty()){
                st[i] = st[i].toLowerCase();
                String r = Character.toString(st[i].charAt(0));
                answer += r.toUpperCase();
                answer += st[i].substring(1,st[i].length());
            }
            answer += " ";
        }
        answer = answer.substring(0, answer.length()-1);
        return answer;
    }
}