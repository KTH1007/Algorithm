import java.util.*;

class Solution {
    public List<int[]> solution(int n) {
        List<int[]> answer = new ArrayList<>();
        // 큰 거에서 작은 거로 옮겨야 됨
        // 재귀 사용
        
        hanoi(n, 1, 2, 3, answer);
        return answer;
    }
    
    static void hanoi(int n, int from, int stopover, int to, List<int[]> answer) {
        if (n == 1) {
            answer.add(new int[] {from, to});
            return;
        }
        
        // 1에서 2번으로 이동
        hanoi(n - 1, from, to, stopover, answer);
        // 가장 큰 원판을 3으로 이동
        answer.add(new int[] {from, to});
        // 2에서 3번으로 이동
        hanoi(n - 1, stopover, from, to, answer);
    }
}