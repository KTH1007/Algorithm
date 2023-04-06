import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<survey.length; i++){
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);
            if(choices[i] < 4){
                map.put(a, (4-choices[i]) + map.getOrDefault(a, 0));
            }
            else if(choices[i] > 4)
                map.put(b, (choices[i]-4) + map.getOrDefault(b, 0));
        }
        //RT
        if(map.getOrDefault('R', 0) == map.getOrDefault('T', 0)){
            answer += "R";
        }
        else if(map.getOrDefault('R', 0) > map.getOrDefault('T', 0))
            answer += "R";
        else
            answer += "T";
        //CF
        if(map.getOrDefault('C', 0) == map.getOrDefault('F', 0)){
            answer += "C";
        }
        else if(map.getOrDefault('C', 0) > map.getOrDefault('F', 0))
            answer += "C";
        else
            answer += "F";
        //JM
        if(map.getOrDefault('J', 0) == map.getOrDefault('M', 0)){
            answer += "J";
        }
        else if(map.getOrDefault('J', 0) > map.getOrDefault('M', 0))
            answer += "J";
        else
            answer += "M";
        //AN
        if(map.getOrDefault('A', 0) == map.getOrDefault('N', 0)){
            answer += "A";
        }
        else if(map.getOrDefault('A', 0) > map.getOrDefault('N', 0))
            answer += "A";
        else
            answer += "N";
        return answer;
    }
}