import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        int[] countArr = new int[map.size()];
        
        int n = 0;
        for (int key : map.keySet()) {
            countArr[n++] = map.get(key);
        }
        
        Arrays.sort(countArr);
        
        for (int i = countArr.length - 1; i >= 0; i--) {
            k -= countArr[i];
            answer++;
            
            if (k <= 0) break;
        }
        
        return answer;
    }
}