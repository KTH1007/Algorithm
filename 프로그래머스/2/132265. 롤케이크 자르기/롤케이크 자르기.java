import java.util.*;


class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        /*
        토핑의 가짓수가 같아야 함
        공평하게 나눌 수 있는가? 되면 공평하게 나눌 수 있는 방법의 개수 리턴
        
        1번째부터 i - 1 번째까지 잘라보기
        1번째를 자르면 0~1 / 2~len 까지가 한 덩어리
        각 형제의 map 필요
        map이 0이 되면 삭제
        
        1 / 2 1 3 4
        1 2 / 1 3 4 2
        1 2 / 3 1 4 2
        1 2 3 / 1 4 2  통과
        1 2 3 / 4 1 2 통과
        1 2 3 4 / 1 2
        1 2 3 4 / 2
        */
        
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        map1.put(topping[0], 1);
        
        for (int i = 1; i < topping.length; i++) {
            map2.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
        }
        
        for (int i = 1; i < topping.length - 1; i++) {
            map1.put(topping[i], map1.getOrDefault(topping[i], 0) + 1);
            map2.put(topping[i], map2.get(topping[i]) - 1);
            
            if (map2.get(topping[i]) <= 0) map2.remove(topping[i]);
            
            if (map1.size() == map2.size()) answer++;
        }
        return answer;
    }
    
}