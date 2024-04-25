import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
    
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i = 0; i < discount.length - 10 + 1; i++) {
            HashMap<String, Integer> discountMap = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                discountMap.put(discount[i + j],
                                discountMap.getOrDefault(discount[i + j], 0) + 1);
                
            }
            boolean flag = true;
            for (String key : map.keySet()) {
                if (map.get(key) != discountMap.get(key)) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) answer++;
        }
        
        
        return answer;
    }
}