import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        int count = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(Character.toString(c), count++);
        }
        
        for (int i = 0; i < msg.length(); i++) {
            int length = 1;
            while (msg.length() >= i + length && map.containsKey(msg.substring(i, i + length))) {
                length++;
            }
            
            if (i + length > msg.length()) {
                list.add(map.get(msg.substring(i)));
                break;
            }
            
            map.put(msg.substring(i, i + length), count++);
            list.add(map.get(msg.substring(i, i + length - 1)));
            
            if (i > 0) {
                i = i + length - 2;
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}