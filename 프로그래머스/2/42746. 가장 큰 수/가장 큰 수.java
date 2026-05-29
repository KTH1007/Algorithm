import java.util.*;

// stirng 형으로 배열 정렬

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(str, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
        }
        
        String temp = sb.toString();
        if (temp.charAt(0) == '0') {
            return "0";
        }
        
        answer = temp;
        
        return answer;
    }
}