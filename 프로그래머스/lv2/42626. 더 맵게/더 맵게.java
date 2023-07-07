import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        int min = pq.peek();
        while(K > min && pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            int temp = a + (b*2);
            pq.add(temp);
            min = pq.peek();
            answer++;
        }
        if(K > min)
            answer = -1;
        return answer;
    }
}