import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        /*
        각 종류별로 착용 or 미착용
        얼굴 3, 상의 2, 하의 2, 겉옷 2 다 합치고 아예 미착용 1 빼기
        8
        
        각 종류별 개수 저장이 필요
        */
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            String clothesType = clothes[i][1];
            map.put(clothesType, map.getOrDefault(clothesType, 1) + 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                // System.out.println(key + " " + map.get(key));
                answer *= map.get(key);
            }
        }
        return answer - 1;
    }
}