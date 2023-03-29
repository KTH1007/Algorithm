import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int[] xnum = new int[10];
        int[] ynum = new int[10];
        for(int i=0; i<X.length(); i++){
            xnum[X.charAt(i)-'0']++;
        }
        for(int i=0; i<Y.length(); i++){
            ynum[Y.charAt(i)-'0']++;
        }
        for(int i=9; i>=0; i--){
            for(int j=0; j<Math.min(xnum[i], ynum[i]); j++){
                sb.append(Integer.toString(i));
            }
        }
        answer = sb.toString();
        if(answer.equals(""))
            return "-1";
        if(answer.charAt(0) == '0')
            return "0";
        return answer;
    }
}