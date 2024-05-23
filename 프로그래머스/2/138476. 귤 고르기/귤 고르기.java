import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (int key : map.keySet()) {
            list.add(map.get(key));
        }
        Collections.sort(list, Collections.reverseOrder());
        
        while (k > 0) {
            k -= list.get(answer);
            answer++;
        }
        
        return answer;
    }
}