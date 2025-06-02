import java.util.*;
class Solution {
    static List<int[]>[] edges;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
    
        // 간선 정보 목록 생성
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        
        // 간선 정보 삽입
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int cost = r[2];
            
            edges[a].add(new int[] {b, cost});
            edges[b].add(new int[] {a, cost});
        }
        
        // 조건에 맞으면 카운트 증가
        int[] distance = dijkstra(N);
        for (int dist : distance) {
            if (dist <= K) answer++;
        }
        
        // 1번 마을인 경우 빼기
        return answer - 1;
    }
    
    private static int[] dijkstra(int N) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        boolean[] visited = new boolean[N + 1];
        
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] {1, 0});
        
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];
            
            // 이미 방문한 노드인 경우
            if (visited[node]) continue;
            visited[node] = true;
            distance[node] = dist;
            
            for (int[] edge : edges[node]) {
                int neighbor = edge[0];
                int cost = edge[1];
                
                pq.add(new int[] {neighbor, dist + cost});
            }
        }
        
        return distance;
    }
}