import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {return o1 - o2;});
        
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while (pq.size() > 1) {
            if (pq.peek() >= K) break;
            else {
                pq.add(pq.poll() + (pq.poll() * 2));
                answer++;
            }
        }
        if (pq.peek() < K) answer = -1;
        return answer;
    }
}