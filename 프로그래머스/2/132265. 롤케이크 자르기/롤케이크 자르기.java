import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = -1;
        
        // 맛의 개수가 같아야함 -> Set 사용
        // 공평한 방법의 수
        // cutPosition이 n이면 왼쪽은 n - 1까지 오른쪽은 n부터 length - 1까지
        // 이분 탐색?
        
        answer = toppingCount(topping);
        return answer;
    }
    
    private static int toppingCount(int[] topping) {
        int cutPostion = 0;
        
        Map<Integer, Integer> chulsoo = new HashMap<>();
        Map<Integer, Integer> brother = new HashMap<>();
        
        for (int i = 0; i < cutPostion; i++) {
            chulsoo.put(topping[i], chulsoo.getOrDefault(topping[i] , 0) + 1);
        }
        
        for (int i = cutPostion; i < topping.length; i++) {
            brother.put(topping[i], brother.getOrDefault(topping[i], 0 ) + 1);
        }
        
        int count = 0;
        
        
        while (cutPostion < topping.length) {
            if (chulsoo.size() == brother.size()) {
                count++;
            }
            
            chulsoo.put(topping[cutPostion], chulsoo.getOrDefault(topping[cutPostion], 0) + 1);
            brother.put(topping[cutPostion], brother.getOrDefault(topping[cutPostion], 0) - 1);
            
            if (brother.get(topping[cutPostion]) == 0) {
                brother.remove(topping[cutPostion]);
            }
            
            cutPostion++;
        }
        
        return count;
    }
}