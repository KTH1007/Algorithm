import java.util.*;

// 모든 음식 K 이상
// 가장 맵지 않은 지수 + (두번 째 * 2)
// 모든 음식이 K 이상 -> 정렬시 맨 처음이 K 이상 -> pq?
// 섞어야 하는 최소 횟수

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Long> pq = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
        
        for (int i : scoville) {
            pq.offer((long) i);
        }
        
        while (pq.size() > 1 && pq.peek() < K) {
            long current = pq.poll();
            long next = pq.poll();
            
            pq.offer(current + (next * 2));
            answer++;
        }
        
        if (pq.peek() < K) {
            return -1;
        }
        
        return answer;
    }
}