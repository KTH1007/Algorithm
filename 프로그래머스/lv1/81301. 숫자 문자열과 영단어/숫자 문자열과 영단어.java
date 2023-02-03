import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        List<String> words = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        for(int i=0; i<words.size(); i++){
            s = s.replace(words.get(i), Integer.toString(words.indexOf(words.get(i))));
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}