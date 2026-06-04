import java.util.*;

// 각 큐마다 합을 미리 계산
// 큐의 합의 절반이 되어야 함
// 큐에 절반보다 큰 수가 있으면 -1
// 14 16인경우 1번큐에 값을 2번으로, 2번큐의 값을 1번으로 vs
// 2번큐의 값을 1번으로만 하는 것중 뭐가 더 중간 값에 가까워지는지

class Solution {
    static long sum1 = 0;
    static long sum2 = 0;
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        
        for (int x : queue1) { 
            q1.offer(x);
            sum1 += x; 
        }
        for (int x : queue2) { 
            q2.offer(x);
            sum2 += x;
        }
        
        long total = sum1 + sum2;
        
        if (!validateNum(queue1, queue2, total)) {
            return -1;
        }

        while (sum1 != sum2) {
            if (answer >= (queue1.length + queue2.length) * 2) {
                return -1;
            }
            moveNum(q1, q2);
            answer++;
        }
        
        return answer;
    }
    
    // 합이 큰 큐에서 작은 큐로 이동
    private static void moveNum(Deque<Integer> q1, Deque<Integer> q2) {
        int count = 0;
        long mid = (sum1 + sum2) / 2;
        if (sum1 > mid) {
            int num = q1.poll();
            q2.offer(num);
            sum1 -= num;
            sum2 += num;
        } else {
            int num = q2.poll();
            q1.offer(num);
            sum1 += num;
            sum2 -= num;
        }
    }
    
    private static boolean validateNum(int[] queue1, int[] queue2, long total) {
        if (total % 2 != 0) {
            return false;
        }
        long mid = total / 2;
        
        for (int i = 0; i < queue1.length; i++) {
            if (queue1[i] > mid) {
                return false;
            }
        }
        
        for (int i = 0; i < queue2.length; i++) {
            if (queue2[i] > mid) {
                return false;
            }
        }
        
        return true;
    }
}