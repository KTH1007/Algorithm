import java.util.*;

// 몸무게가 같으면 짝수개 있는지 확인 홀수면 -1개 만큼
// 현재 몸무게 * 2 3 4 해보기

class Solution {
    static int[][] ratios = {{1,1},{1,2},{2,3},{3,4}};
    
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int weight : weights) {
            // 추가
            map.put(weight, map.getOrDefault(weight, 0) + 1); 
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        
        for (int i = 0; i < keys.size(); i++) {
            for (int j = i; j < keys.size(); j++) {
                int w1 = keys.get(i);
                int w2 = keys.get(j);
                
                if (isValid(w1, w2)) {
                    long c1 = map.get(w1);
                    long c2 = map.get(w2);
                    
                    if (w1 == w2) {
                        answer += (c1 * (c1 - 1)) / 2;
                    } else {
                        answer += c1 * c2;
                    }
                }
            }
        }
        
        return answer;
    }
    
    private static boolean isValid(int w1, int w2) {
        for (int[] r : ratios) {
            if (w1 % r[0] == 0 && w1 / r[0] * r[1] == w2) {
                return true;
            }
        }
        
        return false;
    }
}