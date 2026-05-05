import java.util.*;

// dfs로 탐색하면서 값 구하기


class Solution {
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    
    public int solution(int x, int y, int n) {
        visited = new boolean[y + 1];
        int answer = 0;
        bfs(x, y, n);
        
        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        answer = result;
        return answer;
    }
    
    private static void bfs(int num, int target, int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{num, 0});
        visited[num] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNum = current[0];
            int currentCount = current[1];
            
            if (currentNum == target) {
                result = Math.min(result, currentCount);
                return;
            }
            
            if (currentNum + n <= target && !visited[currentNum + n]) {
                queue.add(new int[]{currentNum + n, currentCount + 1});
                visited[currentNum + n] = true;
            }
            
            if (currentNum * 2 <= target && !visited[currentNum * 2]) {
                queue.add(new int[]{currentNum * 2, currentCount + 1});
                visited[currentNum * 2] = true;
            }
            
            if (currentNum * 3 <= target && !visited[currentNum * 3]) {
                queue.add(new int[]{currentNum * 3, currentCount + 1});
                visited[currentNum * 3] = true;
            }
        }
    }
}