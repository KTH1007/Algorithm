import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wantProductAndCount = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantProductAndCount.put(want[i], number[i]);
        }

        answer = slidingWindow(wantProductAndCount, discount);
        return answer;
    }
    
    private static int slidingWindow(Map<String, Integer> wantProductAndCount, String[] discount) {

        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < 10; i++) {
            if (wantProductAndCount.containsKey(discount[i])) {
                map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            }
        }
        
        int count = 0;

        if (checkCount(wantProductAndCount, map)) {
            count++;
        }
        
        int day = 0;
        int right = 10;
        while(right < discount.length) {
            if (wantProductAndCount.containsKey(discount[day])) {
                map.put(discount[day], map.get(discount[day]) - 1);
                if (map.get(discount[day]) == 0) {
                    map.remove(discount[day]);
                }
            }
            
            if (wantProductAndCount.containsKey(discount[right])) {
                map.put(discount[right], map.getOrDefault(discount[right], 0) + 1);
            }
            
            if (checkCount(wantProductAndCount, map)) {
                count++;
            }
            
            day++;
            right++;
        }
        
        return count;
    }
    
    private static boolean checkCount(Map<String, Integer> wantProductAndCount, Map<String, Integer> map) {
        
        for (String key : wantProductAndCount.keySet()) {
            if (!wantProductAndCount.get(key).equals(map.getOrDefault(key, 0))) {
                return false;
            }
        }
        
        return true;
    }
}