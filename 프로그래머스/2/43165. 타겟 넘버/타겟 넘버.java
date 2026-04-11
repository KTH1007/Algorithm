import java.util.*;

class Solution {
    static boolean[] visited;
    static int count;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        visited = new boolean[numbers.length];
        // dfs로 number 맞춰가기, target이면 카운트증가
        // 방문 체크 필요
        // dfs 돌릴 때 현재값 더하거나 빼거나
        
        dfs(0, numbers, target, 0);
        answer = count;
        return answer;
    }
    
    private static void dfs(int depth, int[] numbers, int target, int num) {
        if (depth == numbers.length) {
            if (num == target) {
                count++;
            }
            return;
        }
        
        dfs(depth + 1, numbers, target, num + numbers[depth]);
        dfs(depth + 1, numbers, target, num - numbers[depth]);
        
    }
}