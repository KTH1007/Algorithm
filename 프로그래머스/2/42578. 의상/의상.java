import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            // 옷의 개수 + 안 입은 경우
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        
        for (String key : map.keySet()) {
            answer *= map.get(key);
        }
        
        // 아예 안 입은 경우 빼기
        return answer - 1;
    }
}