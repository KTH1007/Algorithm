import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        int count = 27;
        
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(Character.toString(c), c - 'A' + 1);
        }
        
        for (int i = 0; i < msg.length(); i++) {
            int length = 1;
            
            // 값이 존재하면 length 증가
            while (i + length <= msg.length() && map.containsKey(msg.substring(i, i + length))) {
                length++;
            }
            
            // i + length 값이 msg 길이를 넘으면 i번째 문자부터 끝까지 추가
            if (i + length > msg.length()) {
                list.add(map.get(msg.substring(i)));
                break;
            }
            
            // 이미 있는 문자의 값을 list에 넣고 없었던 문자는 map에 추가
            list.add(map.get(msg.substring(i, i + length - 1)));
            map.put(msg.substring(i, i + length), count++);
            
            // KAKAO  KA가 있을 때 KA는 length가 3 i값은 2  4부터 시작해야함
            // 위의 경우 i값에 1을 더한 후 반복문이 실행됐을 때 +1이 되면서 4부터 시작
            if (length > 1) {
                i += length - 2;
            }
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}