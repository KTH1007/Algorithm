import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < cities.length; i++) {
            String s = cities[i].toUpperCase();
            if (list.contains(s)) answer += 1;
            else answer += 5;
            
            if (list.contains(s)) {
                list.remove(s);
            }
            list.add(s);
            if (list.size() > cacheSize) list.remove(0);
        }

        return answer;
    }
}