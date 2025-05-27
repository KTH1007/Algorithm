import java.util.*;

class Solution {
    static List<Integer>[] list; // 양방향 그래프
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        list = new ArrayList[n + 1];
        for (int i = 1; i<= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        // 간선 삽입
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        int[] distance = bfs(1, n); // 1번 노드에서 출발
        
        // 최댓값 찾기
        Arrays.sort(distance);
        int max = distance[distance.length - 1];
        for (int i = 0; i < distance.length; i++) {
            if (max == distance[i]) answer++;
        }
        return answer;
    }
    
    private static int[] bfs(int start, int n) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        
        Deque<int[]> queue = new ArrayDeque<>();
        // 시작 노드 queue에 넣기
        queue.add(new int[] {start, 0});
        
        while (queue.size() > 0) {
            int[] current = queue.poll();
            int node = current[0];
            int dist = current[1];
            
            // 방문한 노드인 경우
            if (distance[node] != -1) continue;
            distance[node] = dist;
            
            for (int l : list[node]) {
                queue.add(new int[] {l, dist + 1});
            }
        }
        return distance;
    }
}