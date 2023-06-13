import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] s : clothes){
            // 옷의 개수 + 안 입은 경우
            map.put(s[1], map.getOrDefault(s[1], 1) + 1);
        }
        for(String key : map.keySet()){
            answer *= map.get(key);
        }
        //아무것도 입지 않은 경우를 빼줌
        return answer-1;
    }
}