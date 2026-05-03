import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) (65 + i);
            strList.add(c + "");
        }
        
        List<Integer> numbers = new ArrayList<>();
        
        for (int i = 0; i < msg.length(); i++) {
            if (i == msg.length() - 1) {
                char c = msg.charAt(i);
                numbers.add(strList.indexOf(c + "") + 1);
                break;
            }
            
            String s = getStr(i, msg, strList);
            numbers.add(strList.indexOf(s) + 1);
            i += s.length() - 1;
        }
        
        answer = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            answer[i] = numbers.get(i);
        }
        return answer;
    }
    
    // i부터 i + n 까지 탐색하면서 마지막으로 존재하는 문자열 반환 후 새로운 문자열은 추가
    private static String getStr(int i, String msg, List<String> strList) {
        int right = i;
        String subStr = msg.substring(i, right + 1);

        // System.out.println("1");
        
        while(strList.contains(subStr) && (right + 1) < msg.length()) {
            right++;
            subStr = msg.substring(i, right + 1);
        }
        
        subStr = msg.substring(i, right + 1);

        if (!strList.contains(subStr)) {
            strList.add(subStr);
            return msg.substring(i, right);
        } else {
            return subStr;
        }
    }
}