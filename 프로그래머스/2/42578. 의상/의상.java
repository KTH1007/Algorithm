import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        // map에 값이 없는 경우 기본 값 0
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int mul = 1;
        
        // 의상 하나만 입었을 경우와 조합해서 입었을 경우
        for (String s : map.keySet()) {
            mul *= (map.get(s) + 1);
            System.out.println("mul: " + mul);
        }
        
        answer = mul - 1;
        return answer;
    }
}