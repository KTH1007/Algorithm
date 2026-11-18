import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        /*
        Jeju, pangyo, seoul 15
        pan, seo, jej 16
        seo je pan 17
        je pan seo 18
        
        큐에 있는지 없는지 비교
        캐시 사이즈보다 큐가 작으면 없는 경우는 그냥 추가
        이미 있는 경우는 있는거 제거 후 추가
        
        큐가 더 크면
        
        */
        
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }
        
        Queue<String> queue = new ArrayDeque<>();
        
        for (int i = 0; i < cities.length; i++) {
            if (queue.contains(cities[i])) {
                queue.remove(cities[i]);
                queue.add(cities[i]);
                
                answer++;
            } else {
                queue.add(cities[i]);
                answer += 5;
            }
            
            if (queue.size() > cacheSize) queue.poll();
        }
        return answer;
    }
}