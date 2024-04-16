import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        
        for (int i = 0; i < list.size(); i++) {
            if (k <= 0) break;
            k -= map.get(list.get(i));
            answer++;
        }
        
        return answer;
    }
}

/*
hashmap에 저장 후 같은 귤 크기 카운트 증가


*/