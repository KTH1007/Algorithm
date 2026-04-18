import java.util.*;

        // 연결된 컴퓨터 묶음이 하나의 네트워크
        // List<>[]로 탐색 후 방문체크
        // 방문하지 않은 컴퓨터 개수 + 1이 최종값

class Solution {
    
    static List<Integer>[] edges;
    static boolean[] visited;
    static int count = 0;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        edges = new ArrayList[n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i || computers[i][j] == 0) continue;
                edges[i].add(j);
                edges[j].add(i);
            }
        }
        
        for (int i = 0; i < n; i++) {
            bfs(i);
        }

        answer = count;
        return answer;
    }
    
    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        if (visited[start]) {
            return;
        }
        count++;
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < edges[current].size(); i++) {
                int next = edges[current].get(i);
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                queue.add(next);
            }
        }
    }
}