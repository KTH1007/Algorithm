import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 최소힙 사용
        Queue<Integer> queue = new PriorityQueue<>();
        
        for (int i : scoville) {
            queue.add(i);
        }
        
        
        // 만약 k를 넘지 못했을 경우 flag는 false로 설정
        boolean flag = false;
        while (queue.size() > 1) {
            if (queue.peek() >= K) {
                flag = true;
                break;
            }
            
            queue.add(queue.poll() + queue.poll() * 2);
            answer++;
        }
        
        // queue size가 1이지만 값이 K를 넘긴 경우
        if (queue.peek() >= K) return answer;
        
        if (!flag) answer = -1;
        return answer;
    }
}