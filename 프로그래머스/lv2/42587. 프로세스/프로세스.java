import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<priorities.length; i++){
            pq.add(priorities[i]);
        }
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == pq.peek()){
                    if(i == location){
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}