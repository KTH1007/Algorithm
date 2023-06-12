import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        
        // 캐시 사이즈가 0인 경우는 캐시 확인을 하지 않음
        if(cacheSize == 0){
            answer = cities.length * 5;
            return answer;
        }
        
        // 도시 배열만큼 반복
        for(int i=0; i<cities.length; i++){
            // 캐시에 존재하는 경우
            String s = cities[i].toLowerCase();
            if(queue.contains(s)){
                queue.remove(s);
                queue.add(s);
                answer++;
            } 
                
            // 캐시에 존재하지 않는 경우
            else{
                answer += 5;
                // cacheSize보다 작은 경우는 도시 이름 추가
                if(queue.size() < cacheSize){
                    queue.add(s);
                }
                // 캐시가 가득 찬 경우는 맨 앞에 하나 빼고 추가
                else{
                    queue.remove();
                    queue.add(s);
                }
                
            }
            
        }
        return answer;
    }
}