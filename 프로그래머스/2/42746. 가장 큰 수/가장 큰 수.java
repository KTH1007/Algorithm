import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
        
        // 문자열 리스트로 변환
        for (int num : numbers) {
            list.add(String.valueOf(num));
        }
        
        // 두 수를 합친 값으로 내림차순 정렬
        list.sort((o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s2.compareTo(s1);
        });
        
        StringBuilder sb = new StringBuilder();
        
        for (String num : list) {
            sb.append(num);
        }
        
        answer = sb.toString();
        
        if (answer.charAt(0) == '0') answer = "0";
        return answer;
    }
}