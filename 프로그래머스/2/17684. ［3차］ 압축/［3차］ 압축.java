import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (char c = 'A'; c <= 'Z'; c++) {
            String s = Character.toString(c);
            map.put(s, c - 'A' + 1);
        }
        
        int count = 27;
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < msg.length(); i++) {
            int length = 1;
            while (i + length <= msg.length() && map.containsKey(msg.substring(i, i + length))) {
                length++;
            }
            if (i + length > msg.length()) {
                // i번째 문자부터 끝까지 추가
                list.add(map.get(msg.substring(i)));
                break;
            }
            //KAKAO -> map.get("K") 값을 list에 넣고 "KA"는 map에 추가
            list.add(map.get(msg.substring(i, i + length - 1)));
            map.put(msg.substring(i, i + length), count++);
            
            if (length > 1) i += length - 2;
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
